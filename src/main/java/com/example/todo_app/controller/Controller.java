package com.example.todo_app.controller;

import com.example.todo_app.model.Task;
import com.example.todo_app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("newTask", new Task());
        return "home";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute("newTask") Task task) {
        taskService.addTask(task.getDescription());
        return "redirect:/";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model){
        Task task = taskService.getAllTasks().stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task not found"));
        model.addAttribute("task", task);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editTask (@PathVariable Long id, @RequestParam String description){
        taskService.editTask(id, description);
        return "redirect:/"; // Возвращение на главную страницу
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}
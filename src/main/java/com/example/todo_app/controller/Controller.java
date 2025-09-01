package com.example.todo_app.controller;

import com.example.todo_app.model.Priority;
import com.example.todo_app.model.Task;
import com.example.todo_app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private TaskService taskService;

    @ModelAttribute("newTask")
    public Task newTask() {
        return new Task();
    }

    @GetMapping("/")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "home";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute("newTask") Task task) {
        taskService.addTask(task);
        return "redirect:/";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, @RequestParam String description) {
        taskService.editTask(id, description);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/set-priority/{id}")
    public String setPriority(@PathVariable Long id, Model model) {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "set-priority";
    }

    @PostMapping("/update-priority/{id}")
    public String updatePriority(@PathVariable Long id, @RequestParam String priority) {
        try {
            Priority prio = Priority.valueOf(priority.toUpperCase());
            taskService.updatePriority(id, prio);
        } catch (IllegalArgumentException e) {
            taskService.updatePriority(id, Priority.LOW);
        }
        return "redirect:/";
    }
}
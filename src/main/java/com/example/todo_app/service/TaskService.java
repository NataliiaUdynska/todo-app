package com.example.todo_app.service;

import com.example.todo_app.model.Task;
import com.example.todo_app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Указывает, что этот класс является сервисом
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;// Подключение репозитория для работы с БД

    //Возвращает все задачи из таблицы
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    //Добавление новой задачи
    public Task addTask(String description) {
        Task task = new Task(description);
        return taskRepository.save(task);
    }

    //Подключение статуса выполнено/ не выполнено
   public Task toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));//Задание не найдено
        task.setCompleted(!task.isCompleted());
        return taskRepository.save(task);
    }

    //Редактирование задачи
    public Task editTask(Long id, String description){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setDescription(description);
        return taskRepository.save(task);
    }

    //Удаление задачи по id
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
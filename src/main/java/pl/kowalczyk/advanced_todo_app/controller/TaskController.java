package pl.kowalczyk.advanced_todo_app.controller;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import pl.kowalczyk.advanced_todo_app.model.TaskRepository;

@RepositoryRestController
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }
}

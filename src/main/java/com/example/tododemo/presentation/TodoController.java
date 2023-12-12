package com.example.tododemo.presentation;

import com.example.tododemo.domain.Todo;
import com.example.tododemo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todo")
public class TodoController {

  private final TodoService todoService;

  @GetMapping("/{id}")
  public Todo getTodo(@PathVariable("id") String todoId) {
    return todoService.findTodo(todoId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Todo createTodo(@RequestBody CreateTodoCommand todoCommand) {
    return todoService.createTodo(todoCommand);
  }
}

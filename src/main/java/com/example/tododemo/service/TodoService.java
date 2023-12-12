package com.example.tododemo.service;

import com.example.tododemo.domain.Todo;
import com.example.tododemo.persistence.TodoRepository;
import com.example.tododemo.presentation.CreateTodoCommand;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
  private final Logger LOGGER = LoggerFactory.getLogger(TodoService.class);

  private final TodoRepository todoRepository;
  private final TodoDomainValidationService todoDomainValidationService;

  public Todo findTodo(String todoId) {
    LOGGER.info("Find todoTask with id {}", todoId);

    Todo todobyId = todoDomainValidationService.getTodobyId(todoId);

    LOGGER.info("Successfully found todoTask with id {}", todoId);

    return todobyId;
  }

  public Todo createTodo(CreateTodoCommand command) {
    LOGGER.info("Create new todoTask with id {}", command);

    Todo save = todoRepository.save(new Todo(command.title(), command.completed()));

    LOGGER.info("Successfully created new todoTask with id {}", command);
    return save;
  }

  // not tested
  public Todo updateTodo(String todoId, CreateTodoCommand command) {
    LOGGER.info("Update todo with id {} and command {}", todoId, command);

    Todo todo = todoDomainValidationService.getTodobyId(todoId);

    todo.setTitle(command.title());
    todo.setCompleted(command.completed());

    todoRepository.save(todo);

    LOGGER.info("Successfully updated todoTask");

    return todo;
  }

  // not tested
  public void deleteTodo(String todoId) {
    LOGGER.info("Delete todo with id {}", todoId);

    todoDomainValidationService.getTodobyId(todoId);
    todoRepository.deleteById(new ObjectId(todoId));

    LOGGER.info("Successfully deleted todoTask");
  }
}

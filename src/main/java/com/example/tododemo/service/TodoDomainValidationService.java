package com.example.tododemo.service;

import com.example.tododemo.domain.Todo;
import com.example.tododemo.persistence.TodoRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoDomainValidationService {
  private final TodoRepository todoRepository;

  public Todo getTodobyId(String todoId) {
    Optional<Todo> todoOptional = todoRepository.findById(new ObjectId(todoId));

    return todoOptional.orElseThrow(
        () -> new IllegalArgumentException("Todo with Id: " + todoId + "does not exist"));
  }
}

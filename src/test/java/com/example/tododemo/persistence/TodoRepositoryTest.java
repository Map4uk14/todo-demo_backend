package com.example.tododemo.persistence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import com.example.tododemo.domain.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
class TodoRepositoryTest {
  @Autowired private TodoRepository todoRepository;

  @Test
  public void ensure_findById_returnsTodo() {
    // Given
    var todo = new Todo("Bondarchakk suck dick", true);

    // save to db
    todoRepository.save(todo);

    // When
    var todoReturned = todoRepository.findById(todo.getId());

    // Then
    assertThat(todoReturned.get(), notNullValue());
  }
}

package com.example.tododemo.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class Todo {
  @Id private ObjectId id;
  private String titel;
  private boolean completed;

  // For us
  public Todo(String titel, boolean completed) {
    this.titel = titel;
    this.completed = completed;
  }

  // Spring data
  public Todo() {}

  public void setTitle(String title) {
    this.titel = title;
  }
}

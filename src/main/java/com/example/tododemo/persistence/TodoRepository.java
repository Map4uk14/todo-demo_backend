package com.example.tododemo.persistence;

import com.example.tododemo.domain.Todo;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, ObjectId> {
  public List<Todo> findByTitelContaining(String text);

  public List<Todo> findByTitelAndCompleted(String text, boolean completed);
}

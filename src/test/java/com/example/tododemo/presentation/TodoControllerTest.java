package com.example.tododemo.presentation;

import static io.restassured.RestAssured.when;

import com.example.tododemo.domain.Todo;
import com.example.tododemo.persistence.TodoRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TodoControllerTest {
  @LocalServerPort private int port;

  @Autowired private TodoRepository todoRepository;

  private Todo todoFixture;

  @BeforeAll
  public void serverSetup() {
    RestAssured.baseURI = "http://localhost";
    RestAssured.port = port;
  }

  @BeforeEach
  public void setup() {
    todoFixture = new Todo("title", false);
    todoRepository.save(todoFixture);
  }

  @Test
  public void testFindTodo() {

    when().get("/api/todo/{id}", todoFixture.getId().toString()).then().statusCode(200);
  }

  /*todo
  @Test
  public void testUpdateTodo() {
      when().get("/api/todo/{id}", todoFixture.getId().toString())
              .then().
  }*/

  @AfterEach
  public void tearDown() {
    todoRepository.deleteAll();
  }
}

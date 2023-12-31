package com.example.tododemo;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) // TODO NO SECURITY AT ALL, IN ORDER TO TEST
//@SpringBootApplication
public class TodoDemoApplication {

  private final Logger LOGGER = LoggerFactory.getLogger(TodoDemoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(TodoDemoApplication.class, args);
  }

  // Command Line Runner
  //  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      LOGGER.info("Command Line runner!");

      String[] benas = ctx.getBeanDefinitionNames();
      Arrays.sort(benas);

      for (String bena : benas) LOGGER.info(bena);
    };
  }
}

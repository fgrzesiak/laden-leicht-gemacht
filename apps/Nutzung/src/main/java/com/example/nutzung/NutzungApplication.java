package com.example.nutzung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NutzungApplication {
  public static void main(String[] args) {

    String urlSpring = System.getenv("SPRING_DATASOURCE_URL");

    if (urlSpring == null)
      urlSpring = "jdbc:mysql://localhost:3307/nutzung";

    String urlRabbit = System.getenv("SPRING_QUEUE_URL");
    if (urlRabbit == null)
      urlRabbit = "localhost";

    System.out.println(" ############SPRING_DATASOURCE_URL############ " + urlSpring);
    System.out.println(" ##############SPRING_QUEUE_URL############ " + urlRabbit);
    System.setProperty("spring.datasource.url", urlSpring);
    System.setProperty("spring.rabbitmq.host", urlRabbit);

    SpringApplication.run(NutzungApplication.class, args);
  }

}

package com.movie.movieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MovieserviceApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(MovieserviceApplication.class, args);
  }

}

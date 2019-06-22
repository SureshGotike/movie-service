package com.movie.movieservice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.movieservice.model.Movie;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController
{

  Logger logger = LoggerFactory.getLogger(MovieController.class);

  @GetMapping("/getMovies")
  public List<Movie> getMovies()
  {

    logger.info("Entered MovieController.getMovies()");
    List<Movie> movies = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();
    InputStream is = this.getClass().getResourceAsStream("/movieList.json");
    try
    {
      movies = objectMapper.readValue(is, new TypeReference<List<Movie>>()
      {
      });
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    logger.info("Exiting MovieController.getMovies()");

    return movies;
  }

}

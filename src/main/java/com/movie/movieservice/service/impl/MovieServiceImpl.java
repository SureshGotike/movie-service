package com.movie.movieservice.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.movieservice.controller.MovieController;
import com.movie.movieservice.model.Movie;
import com.movie.movieservice.service.MovieService;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService
{

  Logger logger = LoggerFactory.getLogger(MovieController.class);

  @Override
  public List<Movie> getMovies()
  {
    logger.info("Entering MovieServiceImpl.getMovies()");

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
      logger.debug("Json Mapper Exception occurred. Exception is {}", e.getMessage());
    }
    logger.info("Exiting MovieServiceImpl.getMovies()");

    return movies;
  }
}

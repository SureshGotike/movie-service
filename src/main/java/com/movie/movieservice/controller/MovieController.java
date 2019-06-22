package com.movie.movieservice.controller;

import com.movie.movieservice.model.Movie;
import com.movie.movieservice.service.MovieService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController
{

  Logger logger = LoggerFactory.getLogger(MovieController.class);

  @Autowired
  private MovieService movieService;

  @GetMapping("/getMovies")
  public List<Movie> getMovies()
  {

    logger.info("Entered MovieController.getMovies()");

    List<Movie> movies = movieService.getMovies();

    logger.info("Exited MovieController.getMovies()");

    return movies;
  }

}

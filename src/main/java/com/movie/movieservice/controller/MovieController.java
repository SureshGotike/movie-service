package com.movie.movieservice.controller;

import com.movie.movieservice.model.Movie;
import com.movie.movieservice.model.MovieDoc;
import com.movie.movieservice.service.MovieDocService;
import com.movie.movieservice.service.MovieService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController
{

  Logger logger = LoggerFactory.getLogger(MovieController.class);

  @Autowired
  private MovieService movieService;

  @Autowired
  private MovieDocService movieDocService;

  @GetMapping("/getMovies")
  public List<Movie> getMovies()
  {

    logger.info("Entered MovieController.getMovies()");

    List<Movie> movies = movieService.getMovies();

    logger.info("Exited MovieController.getMovies()");

    return movies;
  }

  @GetMapping("/getMovieDocs")
  public List<MovieDoc> getMovieDocs(){

    logger.info("Entered MovieController.getMoviesDocs()");
    List<MovieDoc> movies= movieDocService.getMovies();

    logger.info("Exited MovieController.getMoviesDocs()");


    return movies;

  }


  @PostMapping("/createMovieDoc")
  public MovieDoc createMovieDoc(@RequestBody MovieDoc movieDoc){

    logger.info("Entered MovieController.createMovieDoc()");
    logger.info("movie creation data is {}", movieDoc.toString());

    movieDoc = movieDocService.createMovieDoc(movieDoc);

    logger.info("Exited MovieController.createMovieDoc()");

    return movieDoc;

  }
}

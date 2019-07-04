package com.movie.movieservice.service.impl;

import com.movie.movieservice.controller.MovieController;
import com.movie.movieservice.model.MovieDoc;
import com.movie.movieservice.repository.MovieRepository;
import com.movie.movieservice.service.MovieDocService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieDocServiceImpl implements MovieDocService
{

  Logger logger = LoggerFactory.getLogger(MovieController.class);

  @Autowired
  private MovieRepository movieRepository;

  @Override
  public List<MovieDoc> getMovies()
  {
    return movieRepository.findAll();
  }

  @Override
  public MovieDoc createMovieDoc(MovieDoc movieDoc){

    return movieRepository.save(movieDoc);

  }

  @Override
  public Optional<MovieDoc> getMovie(Long id)
  {
    logger.debug("entered getMovie() with Id {}", id);
    return movieRepository.findById(id);
  }
}

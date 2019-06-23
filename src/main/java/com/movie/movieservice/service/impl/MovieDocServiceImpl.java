package com.movie.movieservice.service.impl;

import com.movie.movieservice.model.MovieDoc;
import com.movie.movieservice.repository.MovieRepository;
import com.movie.movieservice.service.MovieDocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieDocServiceImpl implements MovieDocService
{

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
}

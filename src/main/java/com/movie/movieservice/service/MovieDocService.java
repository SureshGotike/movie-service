package com.movie.movieservice.service;

import com.movie.movieservice.model.MovieDoc;
import java.util.List;
import java.util.Optional;

public interface MovieDocService
{

  List<MovieDoc> getMovies();
  Optional<MovieDoc> getMovie(Long id);

  MovieDoc createMovieDoc(MovieDoc movieDoc);


}

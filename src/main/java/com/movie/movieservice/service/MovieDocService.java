package com.movie.movieservice.service;

import com.movie.movieservice.model.MovieDoc;
import java.util.List;

public interface MovieDocService
{

  List<MovieDoc> getMovies();

  MovieDoc createMovieDoc(MovieDoc movieDoc);


}

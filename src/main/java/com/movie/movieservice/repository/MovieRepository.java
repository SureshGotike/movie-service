package com.movie.movieservice.repository;

import com.movie.movieservice.model.MovieDoc;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<MovieDoc, Long>
{
  List<MovieDoc> findAll();

  MovieDoc save(MovieDoc movieDoc);
}

package com.movie.movieservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Movies")
@Getter
@Setter
@ToString
public class MovieDoc
{

  @Id
  private long movieId;

  private String movieName;

  private String movieDescription;

  private String movieImage;

  private double rating;
}

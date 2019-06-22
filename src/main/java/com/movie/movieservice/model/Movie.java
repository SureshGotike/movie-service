package com.movie.movieservice.model;

public class Movie
{

  private long movieId;

  private String movieName;

  private String movieDescription;

  private String movieImage;

  private double rating;


  public long getMovieId()
  {
    return movieId;
  }

  public void setMovieId(long movieId)
  {
    this.movieId = movieId;
  }

  public String getMovieName()
  {
    return movieName;
  }

  public void setMovieName(String movieName)
  {
    this.movieName = movieName;
  }

  public String getMovieDescription()
  {
    return movieDescription;
  }

  public void setMovieDescription(String movieDescription)
  {
    this.movieDescription = movieDescription;
  }

  public String getMovieImage()
  {
    return movieImage;
  }

  public void setMovieImage(String movieImage)
  {
    this.movieImage = movieImage;
  }

  public double getRating()
  {
    return rating;
  }

  public void setRating(double rating)
  {
    this.rating = rating;
  }
}

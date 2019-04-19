package com.example.udemy.sfg.sfgnetflux.services;

import com.example.udemy.sfg.sfgnetflux.domain.Movie;
import com.example.udemy.sfg.sfgnetflux.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Flux<MovieEvent> getEventsByMovieId(String movieId);

    Mono<Movie> getMovieById(String movieId);

    Flux<Movie> getAllMovies();
}

package com.example.udemy.sfg.sfgnetflux.services.impl;

import com.example.udemy.sfg.sfgnetflux.domain.Movie;
import com.example.udemy.sfg.sfgnetflux.domain.MovieEvent;
import com.example.udemy.sfg.sfgnetflux.repositories.MovieRepository;
import com.example.udemy.sfg.sfgnetflux.services.MovieService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Flux<MovieEvent> getEventsByMovieId(String movieId) {
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
            movieEventSynchronousSink.next(new MovieEvent(movieId, new Date()));
        }).delayElements(Duration.ofSeconds(1L));
    }

    @Override
    public Mono<Movie> getMovieById(String movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}

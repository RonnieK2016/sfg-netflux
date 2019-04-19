package com.example.udemy.sfg.sfgnetflux.controllers;

import com.example.udemy.sfg.sfgnetflux.domain.Movie;
import com.example.udemy.sfg.sfgnetflux.domain.MovieEvent;
import com.example.udemy.sfg.sfgnetflux.services.MovieService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public Flux<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Mono<Movie> getMovieById(@PathVariable String id) {
        return  movieService.getMovieById(id);
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieEvent> getMovieEvents(@PathVariable String id) {
        return movieService.getEventsByMovieId(id);
    }
}

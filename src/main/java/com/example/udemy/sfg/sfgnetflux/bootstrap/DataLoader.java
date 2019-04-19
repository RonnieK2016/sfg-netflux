package com.example.udemy.sfg.sfgnetflux.bootstrap;

import com.example.udemy.sfg.sfgnetflux.domain.Movie;
import com.example.udemy.sfg.sfgnetflux.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import reactor.core.publisher.Flux;

import java.util.UUID;

public class DataLoader implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public DataLoader(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll().thenMany(
                Flux.just("Silence of the Lambdas", "AEon Flux", "Enter the Mono<Void>", "The Fluxxinator",
                        "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
                        .map(title -> new Movie(title, UUID.randomUUID().toString()))
                        .flatMap(movieRepository::save)
        ).subscribe(
                null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                }
        );
    }
}

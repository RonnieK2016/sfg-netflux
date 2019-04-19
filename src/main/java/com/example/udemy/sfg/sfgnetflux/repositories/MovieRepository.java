package com.example.udemy.sfg.sfgnetflux.repositories;

import com.example.udemy.sfg.sfgnetflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}

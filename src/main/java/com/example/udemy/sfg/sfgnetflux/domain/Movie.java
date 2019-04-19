package com.example.udemy.sfg.sfgnetflux.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@Data
public class Movie {

    @Id
    private String id;

    @NonNull
    private String title;
}

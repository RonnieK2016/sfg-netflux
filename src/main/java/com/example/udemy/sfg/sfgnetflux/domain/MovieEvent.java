package com.example.udemy.sfg.sfgnetflux.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieEvent {

    private String movieId;

    private Date date;
}

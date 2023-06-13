package com.onedev.feature.movie.data.mapper

import com.onedev.core.network.model.MovieSearchResponse
import com.onedev.feature.movie.domain.model.Movie

fun MovieSearchResponse.toDomainSearchMovieList(): List<Movie>? {
    return this.results?.map {
        Movie(it.id.toString(),"https://image.tmdb.org/t/p/w500/${it.poster_path}")
    }
}
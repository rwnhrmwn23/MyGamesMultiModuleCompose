package com.onedev.feature.movie.domain.repo

import com.onedev.feature.movie.domain.model.Movie

interface MovieRepository {

    suspend fun getSearchMovie(apiKey: String, query: String) : List<Movie>?

}
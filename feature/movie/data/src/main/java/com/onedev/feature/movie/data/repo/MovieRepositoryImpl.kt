package com.onedev.feature.movie.data.repo

import com.onedev.core.network.data.MovieDataProviders
import com.onedev.feature.movie.data.mapper.toDomainSearchMovieList
import com.onedev.feature.movie.domain.model.Movie
import com.onedev.feature.movie.domain.repo.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataProviders: MovieDataProviders
) : MovieRepository {

    override suspend fun getSearchMovie(apiKey: String, query: String): List<Movie>? {
        return movieDataProviders.getSearchMovie(apiKey, query).toDomainSearchMovieList()
    }

}
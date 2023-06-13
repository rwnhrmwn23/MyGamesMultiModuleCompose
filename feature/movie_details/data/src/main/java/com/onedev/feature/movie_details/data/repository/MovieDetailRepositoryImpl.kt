package com.onedev.feature.movie_details.data.repository

import com.onedev.core.network.data.MovieDataProviders
import com.onedev.feature.movie_details.data.mapper.toDomain
import com.onedev.feature.movie_details.domain.model.MovieDetail
import com.onedev.feature.movie_details.domain.repository.MovieDetailRepository
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor (private val movieDataProviders: MovieDataProviders) : MovieDetailRepository {
    override suspend fun getDetailMovie(id: String, apiKey: String): MovieDetail {
        return movieDataProviders.getDetailMovie(id, apiKey).toDomain()
    }
}
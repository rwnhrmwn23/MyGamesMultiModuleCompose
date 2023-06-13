package com.onedev.feature.movie_details.domain.repository

import com.onedev.feature.movie_details.domain.model.MovieDetail

interface MovieDetailRepository {

    suspend fun getDetailMovie(id: String, apiKey: String): MovieDetail

}
package com.onedev.feature.movie_details.ui.screen

import com.onedev.feature.movie_details.domain.model.MovieDetail

data class MovieDetailStateHolder(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: MovieDetail? = null
)
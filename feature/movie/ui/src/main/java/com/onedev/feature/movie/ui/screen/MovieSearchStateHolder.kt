package com.onedev.feature.movie.ui.screen

import com.onedev.feature.movie.domain.model.Movie

data class MovieSearchStateHolder(
    val isLoading: Boolean = false,
    val data: List<Movie>? = null,
    val error: String = ""
)
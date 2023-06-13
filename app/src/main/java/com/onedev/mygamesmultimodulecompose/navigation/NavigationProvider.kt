package com.onedev.mygamesmultimodulecompose.navigation

import com.onedev.feature.movie.ui.navigation.MovieApi
import com.onedev.feature.movie_details.ui.navigation.MovieDetailApi

data class NavigationProvider(
    val movieApi: MovieApi,
    val movieDetailApi: MovieDetailApi
)

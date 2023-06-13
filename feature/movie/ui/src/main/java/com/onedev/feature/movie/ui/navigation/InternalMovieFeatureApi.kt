package com.onedev.feature.movie.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onedev.core.common.navigation_constans.MovieFeature
import com.onedev.core.feature_api.FeatureApi
import com.onedev.feature.movie.ui.screen.MovieScreen
import com.onedev.feature.movie.ui.screen.MovieSearchViewModel

internal object InternalMovieFeatureApi : FeatureApi {

    override fun registerGraph(navController: NavController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            startDestination = MovieFeature.movieScreenRoute,
            route = MovieFeature.nestedRoute
        ) {
            composable(MovieFeature.movieScreenRoute) {
                val viewmodel = hiltViewModel<MovieSearchViewModel>()
                MovieScreen(viewModel = viewmodel, navController)
            }
        }
    }

}
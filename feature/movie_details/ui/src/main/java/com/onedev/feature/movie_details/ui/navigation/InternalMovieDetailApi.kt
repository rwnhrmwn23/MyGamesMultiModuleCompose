package com.onedev.feature.movie_details.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onedev.core.common.navigation_constans.MovieDetailFeature
import com.onedev.core.feature_api.FeatureApi
import com.onedev.feature.movie_details.ui.screen.MovieDetailScreen
import com.onedev.feature.movie_details.ui.screen.MovieDetailViewModel

object InternalMovieDetailApi: FeatureApi {

    override fun registerGraph(navController: NavController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            route = MovieDetailFeature.nestedRoute,
            startDestination = MovieDetailFeature.movieDetailScreenRoute
        ) {
            composable(MovieDetailFeature.movieDetailScreenRoute) {
                val id = it.arguments?.getString("id").toString()
                val viewModel = hiltViewModel<MovieDetailViewModel>()
                MovieDetailScreen(id = id, viewModel = viewModel)
            }
        }
    }

}
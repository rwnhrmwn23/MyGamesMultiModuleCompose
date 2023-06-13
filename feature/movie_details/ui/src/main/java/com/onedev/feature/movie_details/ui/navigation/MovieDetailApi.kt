package com.onedev.feature.movie_details.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.onedev.core.feature_api.FeatureApi

interface MovieDetailApi: FeatureApi {

}

class MovieDetailApiImpl: MovieDetailApi {

    override fun registerGraph(navController: NavController, navGraphBuilder: NavGraphBuilder) {
        InternalMovieDetailApi.registerGraph(navController, navGraphBuilder)
    }

}
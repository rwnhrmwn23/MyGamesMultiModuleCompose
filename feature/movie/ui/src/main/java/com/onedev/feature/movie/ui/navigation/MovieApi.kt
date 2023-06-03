package com.onedev.feature.movie.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.onedev.core.feature_api.FeatureApi

interface MovieApi : FeatureApi {

}

class MovieApiImpl: MovieApi {
    override fun registerGraph(navController: NavController, navGraphBuilder: NavGraphBuilder) {
        InternalMovieFeatureApi.registerGraph(
            navController, navGraphBuilder
        )
    }

}
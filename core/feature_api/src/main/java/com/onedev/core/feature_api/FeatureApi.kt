package com.onedev.core.feature_api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface FeatureApi {

    fun registerGraph(
        navController: NavController,
        navGraphBuilder: NavGraphBuilder
    )

}
package com.onedev.mygamesmultimodulecompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.onedev.core.common.navigation_constans.MovieFeature

@Composable
fun AppNavGraph(
    navHostController: NavHostController, navigationProvider: NavigationProvider
) {
    NavHost(navController = navHostController, startDestination = MovieFeature.nestedRoute) {
        navigationProvider.movieApi.registerGraph(
            navHostController, this
        )
    }
}
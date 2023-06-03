package com.onedev.feature.movie.ui.di

import com.onedev.feature.movie.ui.navigation.MovieApi
import com.onedev.feature.movie.ui.navigation.MovieApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UIModule {

    @Provides
    fun provideMovieApi(): MovieApi {
        return MovieApiImpl()
    }

}
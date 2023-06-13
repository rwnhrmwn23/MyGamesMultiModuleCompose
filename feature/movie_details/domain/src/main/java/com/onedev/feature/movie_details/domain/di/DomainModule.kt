package com.onedev.feature.movie_details.domain.di

import com.onedev.feature.movie_details.domain.repository.MovieDetailRepository
import com.onedev.feature.movie_details.domain.usecases.MovieDetailUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetMovieDetailUseCases(movieDetailRepository: MovieDetailRepository): MovieDetailUseCases {
        return MovieDetailUseCases(movieDetailRepository)
    }

}
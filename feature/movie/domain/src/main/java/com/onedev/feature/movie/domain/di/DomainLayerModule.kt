package com.onedev.feature.movie.domain.di

import com.onedev.feature.movie.domain.repo.MovieRepository
import com.onedev.feature.movie.domain.usecases.GetSearchMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideGetSearchMovieUseCase(movieRepository: MovieRepository): GetSearchMovieUseCase {
        return GetSearchMovieUseCase(movieRepository)
    }

}
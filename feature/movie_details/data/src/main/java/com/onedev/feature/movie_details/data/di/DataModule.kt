package com.onedev.feature.movie_details.data.di

import com.onedev.core.network.data.MovieDataProviders
import com.onedev.feature.movie_details.data.repository.MovieDetailRepositoryImpl
import com.onedev.feature.movie_details.domain.repository.MovieDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideMovieDetailRepository(movieDataProvider: MovieDataProviders): MovieDetailRepository {
        return MovieDetailRepositoryImpl(movieDataProvider)
    }

}
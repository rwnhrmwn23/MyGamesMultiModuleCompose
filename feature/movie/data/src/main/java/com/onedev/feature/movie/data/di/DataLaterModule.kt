package com.onedev.feature.movie.data.di

import com.onedev.core.network.data.MovieDataProviders
import com.onedev.feature.movie.data.repo.MovieRepositoryImpl
import com.onedev.feature.movie.domain.repo.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLaterModule {

    @Provides
    fun provideMovieRepository(movieDataProviders: MovieDataProviders): MovieRepository {
        return MovieRepositoryImpl(movieDataProviders)
    }
}
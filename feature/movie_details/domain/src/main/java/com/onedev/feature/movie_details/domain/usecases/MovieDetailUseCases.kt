package com.onedev.feature.movie_details.domain.usecases

import com.onedev.core.common.UIEvent
import com.onedev.feature.movie_details.domain.repository.MovieDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieDetailUseCases @Inject constructor(private val movieDetailRepository: MovieDetailRepository) {

    operator fun invoke(id: String, apiKey: String) = flow {
        emit(UIEvent.Loading())
        emit(UIEvent.Success(movieDetailRepository.getDetailMovie(id, apiKey)))
    }.catch {
        emit(UIEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

}
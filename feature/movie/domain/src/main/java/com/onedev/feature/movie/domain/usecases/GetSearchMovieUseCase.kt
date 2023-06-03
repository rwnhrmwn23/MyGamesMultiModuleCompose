package com.onedev.feature.movie.domain.usecases

import com.onedev.core.common.UIEvent
import com.onedev.feature.movie.domain.repo.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetSearchMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(apiKey: String, query: String) = flow {
        emit(UIEvent.Loading())
        emit(UIEvent.Success(movieRepository.getSearchMovie(apiKey, query)))
    }.catch {
        emit(UIEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}
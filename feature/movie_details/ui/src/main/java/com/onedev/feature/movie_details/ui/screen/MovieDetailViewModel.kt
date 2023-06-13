package com.onedev.feature.movie_details.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onedev.core.common.UIEvent
import com.onedev.feature.movie_details.domain.usecases.MovieDetailUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCases: MovieDetailUseCases,
    savedStateHanded: SavedStateHandle
) : ViewModel() {

    private val _movieDetail = mutableStateOf(MovieDetailStateHolder())
    val movieDetail: State<MovieDetailStateHolder> get() = _movieDetail

    init {
        savedStateHanded.getLiveData<String>("id").observeForever { id ->
            id?.let {
                getMovieDetail(id,"bdc6a457d157c45294b60ef714eb9a73")
            }
        }
    }

    fun getMovieDetail(id: String, apiKey: String) {
        movieDetailUseCases.invoke(id, apiKey).onEach {
            when (it) {
                is UIEvent.Loading -> {
                    _movieDetail.value = MovieDetailStateHolder(isLoading = true)
                }

                is UIEvent.Error -> {
                    _movieDetail.value = MovieDetailStateHolder(error = it.message.toString())

                }

                is UIEvent.Success -> {
                    _movieDetail.value = MovieDetailStateHolder(data = it.data)

                }
            }
        }.launchIn(viewModelScope)
    }

}
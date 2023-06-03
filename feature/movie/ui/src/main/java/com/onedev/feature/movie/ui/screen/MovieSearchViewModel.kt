package com.onedev.feature.movie.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onedev.core.common.UIEvent
import com.onedev.feature.movie.domain.usecases.GetSearchMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(
    private val getSearchMovieUseCase: GetSearchMovieUseCase
): ViewModel() {

    private val _getSearchMovie = mutableStateOf(MovieSearchStateHolder())
    val getSearchMovie: State<MovieSearchStateHolder> get() = _getSearchMovie

    private val _query : MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                getSearchMovie("bdc6a457d157c45294b60ef714eb9a73", it)
            }
        }
    }

    fun setQuery(s: String) {
        _query.value = s
    }

    fun getSearchMovie(apiKey: String, q: String) = viewModelScope.launch {
        getSearchMovieUseCase(apiKey, q).onEach {
            when (it) {
                is UIEvent.Loading -> {
                    _getSearchMovie.value = MovieSearchStateHolder(isLoading = true)
                }
                is UIEvent.Success -> {
                    _getSearchMovie.value = MovieSearchStateHolder(data = it.data)
                }
                is UIEvent.Error -> {
                    _getSearchMovie.value = MovieSearchStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}
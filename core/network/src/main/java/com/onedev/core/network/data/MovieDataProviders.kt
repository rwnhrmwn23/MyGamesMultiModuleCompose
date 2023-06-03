package com.onedev.core.network.data

import com.onedev.core.network.ApiService
import javax.inject.Inject

class MovieDataProviders @Inject constructor(private val apiService: ApiService) {

    suspend fun getSearchMovie(apiKey: String, query: String) =
        apiService.getSearchMovie(apiKey, query)

}
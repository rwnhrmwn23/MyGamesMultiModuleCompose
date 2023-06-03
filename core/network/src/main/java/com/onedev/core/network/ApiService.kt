package com.onedev.core.network

import com.onedev.core.network.model.MovieSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/search/movie")
    suspend fun getSearchMovie(
        @Query("api_key") apiKey: String,
        @Query("query") query: String,
    ): MovieSearchResponse

}
package com.onedev.feature.movie_details.data.mapper

import com.onedev.core.network.model.MovieDetailResponse
import com.onedev.feature.movie_details.domain.model.MovieDetail

fun MovieDetailResponse.toDomain(): MovieDetail {
    return MovieDetail(
        title = this.original_title.toString(),
        description = this.overview.toString(),
        imageUrl = "https://image.tmdb.org/t/p/w500/${this.poster_path.toString()}",
    )
}
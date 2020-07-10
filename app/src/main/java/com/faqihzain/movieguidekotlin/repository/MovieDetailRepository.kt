package com.faqihzain.movieguidekotlin.repository

import androidx.lifecycle.LiveData
import com.faqihzain.movieguidekotlin.api.MoviesApi
import com.faqihzain.movieguidekotlin.api.responses.ApiEmptyResponse
import com.faqihzain.movieguidekotlin.api.responses.ApiErrorResponse
import com.faqihzain.movieguidekotlin.api.responses.ApiResponse
import com.faqihzain.movieguidekotlin.api.responses.ApiSuccessResponse
import com.faqihzain.movieguidekotlin.models.MovieDetails
import com.faqihzain.movieguidekotlin.util.NetworkBoundResourceNoCaching
import com.faqihzain.movieguidekotlin.util.Resource
import com.faqihzain.movieguidekotlin.api.responses.MovieDetailsResponse

class MovieDetailRepository(
    private val movieApi: MoviesApi
) {

    fun getMovieDetail(movieId: Long): LiveData<Resource<MovieDetails>> {
        return object : NetworkBoundResourceNoCaching<MovieDetails, MovieDetailsResponse>() {
            override fun handleApiSuccessResponse(response: ApiSuccessResponse<MovieDetailsResponse>) {
                val detailsResponse= response.body
                val videos = detailsResponse.videoResponse?.videos
                val casts = detailsResponse.creditsResponse?.casts
                val reviews = detailsResponse.reviewResponse?.reviews
                result.value = Resource.Success(MovieDetails(videos,reviews,casts))
            }

            override fun handleApiEmptyResponse(response: ApiEmptyResponse<MovieDetailsResponse>) {
                result.value = Resource.Success(MovieDetails())
            }

            override fun handleApiErrorResponse(response: ApiErrorResponse<MovieDetailsResponse>) {
                result.value = Resource.Error(response.errorMessage,null)
            }

            override fun createCall(): LiveData<ApiResponse<MovieDetailsResponse>> =
                movieApi.getMovieDetail(movieId)

        }.asLiveData()
    }
}
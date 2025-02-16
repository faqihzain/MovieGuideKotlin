package com.faqihzain.movieguidekotlin.api

import androidx.lifecycle.LiveData
import com.faqihzain.movieguidekotlin.api.responses.ApiResponse
import com.faqihzain.movieguidekotlin.api.responses.MovieDetailsResponse
import com.faqihzain.movieguidekotlin.api.responses.MoviesResponse
import com.faqihzain.movieguidekotlin.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): LiveData<ApiResponse<MoviesResponse>>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): LiveData<ApiResponse<MoviesResponse>>

    @GET("movie/upcoming")
    fun geUpcomingMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): LiveData<ApiResponse<MoviesResponse>>

    @GET("search/movie")
    fun searchMovies(
        @Query("query") query: String? = null,
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): LiveData<ApiResponse<MoviesResponse>>

    @GET("movie/{id}")
    fun getMovieDetail(
        @Path("id") id: Long,
        @Query("append_to_response") details: String = "videos,credits,reviews",
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): LiveData<ApiResponse<MovieDetailsResponse>>

}
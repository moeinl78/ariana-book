package ir.ariyana.arianabooks.repository.remote

import ir.ariyana.arianabooks.repository.model.BooksOverviewResponse
import ir.ariyana.arianabooks.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPI {

    @GET("lists/overview.json")
    suspend fun getBooksOverview(
        @Query("api-key") apiKey: String = Constants.API_KEY
    ): Response<BooksOverviewResponse>
}
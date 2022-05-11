package ir.ariyana.arianabooks.repository.remote

import ir.ariyana.arianabooks.repository.model.BooksOverviewResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPI {

    @GET("lists/overview.json")
    suspend fun getBooksOverview(
        @Query("api-key") apiKey: String = "CFGmGBqGHX5bfNFxZZxh4dtziwgl6PXa"
    ): Response<BooksOverviewResponse>
}
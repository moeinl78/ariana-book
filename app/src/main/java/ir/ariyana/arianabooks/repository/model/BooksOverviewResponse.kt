package ir.ariyana.arianabooks.repository.model


import com.google.gson.annotations.SerializedName

data class BooksOverviewResponse(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: Results,
    @SerializedName("status")
    val status: String
)
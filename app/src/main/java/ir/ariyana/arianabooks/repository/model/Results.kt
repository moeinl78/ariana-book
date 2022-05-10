package ir.ariyana.arianabooks.repository.model


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("bestsellers_date")
    val bestsellersDate: String,
    @SerializedName("lists")
    val lists: List<Lists>,
    @SerializedName("next_published_date")
    val nextPublishedDate: String,
    @SerializedName("previous_published_date")
    val previousPublishedDate: String,
    @SerializedName("published_date")
    val publishedDate: String,
    @SerializedName("published_date_description")
    val publishedDateDescription: String
)
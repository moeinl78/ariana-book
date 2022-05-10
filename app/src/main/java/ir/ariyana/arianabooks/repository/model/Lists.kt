package ir.ariyana.arianabooks.repository.model


import com.google.gson.annotations.SerializedName

data class Lists(
    @SerializedName("books")
    val books: List<Book>,
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("list_id")
    val listId: Int,
    @SerializedName("list_image")
    val listImage: Any,
    @SerializedName("list_image_height")
    val listImageHeight: Any,
    @SerializedName("list_image_width")
    val listImageWidth: Any,
    @SerializedName("list_name")
    val listName: String,
    @SerializedName("list_name_encoded")
    val listNameEncoded: String,
    @SerializedName("updated")
    val updated: String
)
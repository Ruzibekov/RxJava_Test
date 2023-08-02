package uz.ruzibekov.rxjavatest.data.model

data class PostResponse(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)
package com.example.assignment_006.model


import com.google.gson.annotations.SerializedName

data class ContentX(
    val id: String,
    val descriptionEN: String,
    val descriptionKA: String,
    val descriptionRU: String,
    val titleEN: String,
    val titleKA: String,
    val titleRU: String,
    val published: Int,
    @SerializedName("publish_date")
    val publishDate: String,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("updated_at")
    val updatedAt: Long,
    val category: String,
    val cover: String,
    val isLast: Boolean
)
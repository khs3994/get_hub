package com.example.domain.model

import com.google.gson.annotations.SerializedName

data class DomainUserInfo(
    @SerializedName("login")
    val userId: String,
    val followers: Int,
    val following: Int,
)

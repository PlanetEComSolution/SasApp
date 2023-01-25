package com.test.sasapp.model

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("posts" ) var posts : ArrayList<Posts> = arrayListOf(),
    @SerializedName("page"  ) var page  : Int?             = null
)

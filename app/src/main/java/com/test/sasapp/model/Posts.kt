package com.test.sasapp.model

import com.google.gson.annotations.SerializedName

data class Posts (

    @SerializedName("id"              ) var id             : String? = null,
    @SerializedName("thumbnail_image" ) var thumbnailImage : String? = null,
    @SerializedName("event_name"      ) var eventName      : String? = null,
    @SerializedName("event_date"      ) var eventDate      : Int?    = null,
    @SerializedName("views"           ) var views          : Int?    = null,
    @SerializedName("likes"           ) var likes          : Int?    = null,
    @SerializedName("shares"          ) var shares         : Int?    = null

)

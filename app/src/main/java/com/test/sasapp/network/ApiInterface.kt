package com.riser.allotin.network

import android.content.Context
import com.test.sasapp.model.PostResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {



    @GET(ApiConstants.API_EVENT_LIST)
    fun getEventList():Call<PostResponse>


    companion object Factory {
        @Volatile
        private var instance: ApiInterface? = null
        fun init(context: Context): ApiInterface {
            return instance ?: synchronized(this) {
                instance ?: HomeClientApi.callRetrofit(context).also { instance = it }
            }
        }
    }

}
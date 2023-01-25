package com.test.sasapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riser.allotin.network.ApiInterface
import com.test.sasapp.base.SasApp
import com.test.sasapp.model.PostResponse
import retrofit2.Call
import retrofit2.Response

class EventViewModel : ViewModel() {

    private var apiInterface = ApiInterface.init(SasApp.instance)
    var errorMsg: MutableLiveData<String>? = null
    var loadingStatus: MutableLiveData<Boolean>? = null
    var postResponse: MutableLiveData<PostResponse>?=null

    init {

        errorMsg = MutableLiveData()
        loadingStatus = MutableLiveData()
        postResponse = MutableLiveData<PostResponse>()

    }

    fun getEventDetails(){

        loadingStatus?.postValue(true)
        apiInterface.getEventList().enqueue(object : retrofit2.Callback<PostResponse>{
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {

                loadingStatus?.value = false
                postResponse?.value = response.body()

            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                loadingStatus?.value = false
                errorMsg?.value = t.message
            }

        })
    }

    }

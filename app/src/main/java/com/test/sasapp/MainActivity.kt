package com.test.sasapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.sasapp.adapter.EventAdapter
import com.test.sasapp.databinding.ActivityMainBinding
import com.test.sasapp.model.Posts
import com.test.sasapp.room.EventDatabase
import com.test.sasapp.viewmodel.EventViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var eventViewModel: EventViewModel
    var mList = mutableListOf<Posts>()
    lateinit var adapter: EventAdapter
    private val eventDatabase by lazy { EventDatabase.getDatabase(this).eventDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        eventViewModel = ViewModelProvider(this)[EventViewModel::class.java]
        getEventList()
    }

    private fun getEventList() {
        binding.progressBar.visibility = View.VISIBLE
        eventViewModel.getEventDetails()

        eventViewModel.postResponse?.observe(this, Observer {
            if (it != null) {
                val response = it
                mList = response.posts

                if (response.posts.isNotEmpty() == true) {

                    mList = response.posts
                    binding.recyclerView.layoutManager = LinearLayoutManager(this)
                    adapter = EventAdapter(mList)
                    binding.recyclerView.setHasFixedSize(true)
                    binding.recyclerView.adapter = EventAdapter(mList)
                    binding.progressBar.visibility = View.GONE


                }

            }

        })

        eventViewModel.errorMsg?.observe(this, Observer {
            if (it != null) {

                binding.progressBar.visibility = View.GONE

            }

        })


    }

  fun getData(){
  }


}
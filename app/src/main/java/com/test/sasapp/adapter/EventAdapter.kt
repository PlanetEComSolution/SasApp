package com.test.sasapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.test.sasapp.R
import com.test.sasapp.model.Posts

class EventAdapter(private val mList: List<Posts>):
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_event, parent, false)
        context = parent.getContext();
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventAdapter.ViewHolder, position: Int) {
        val Data = mList[position]
        val margin = 20
        holder.textView.text = Data.eventName
        holder.like.text = Data.likes.toString()
        holder.view.text = Data.views.toString()
        holder.share.text = Data.shares.toString()
        Glide.with(context)

            .load(Data.thumbnailImage)
            .centerCrop() // scale image to fill the entire ImageView
            .transform(RoundedCorners(margin))
            .into(holder.imageView)


    }

    override fun getItemCount(): Int {
        return  mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.name)
        val like: TextView = itemView.findViewById(R.id.like_count)
        val view: TextView = itemView.findViewById(R.id.view_count)
        val share: TextView = itemView.findViewById(R.id.share_count)

    }

    }
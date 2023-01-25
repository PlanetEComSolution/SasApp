package com.test.sasapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.test.sasapp.model.Posts

@Dao
interface EventDao {

    @Insert
    fun insertAll(posts: List<Event>)

    @Query("SELECT * FROM events ORDER BY event_date DESC")
    fun getEvents(): List<Event>


}
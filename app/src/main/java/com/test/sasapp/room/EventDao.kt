package com.test.sasapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.sasapp.model.Posts

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(posts: List<Posts>)

    @Query("SELECT * FROM events")
    fun getEvents():List<Posts>


}
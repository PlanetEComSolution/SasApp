package com.test.sasapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Event(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "event_name")
    val eventName: String,
    @ColumnInfo(name = "thumbnailImage")
    val thumbnailImage: String,
    @ColumnInfo(name = "views")
    val views: String,
    @ColumnInfo(name = "likes")
    val likes: String,
    @ColumnInfo(name = "shares")
    val shares: String,
    @ColumnInfo(name = "event_date")
    val event_date: String

)

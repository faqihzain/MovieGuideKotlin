package com.faqihzain.movieguidekotlin.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.faqihzain.movieguidekotlin.persistence.dao.*
import com.faqihzain.movieguidekotlin.models.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converter::class)
abstract class MovieDB : RoomDatabase() {
    abstract val movieDao: MovieAndDetailDao


}
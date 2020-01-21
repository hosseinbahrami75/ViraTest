package com.android.vira.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.vira.api.models.response.GameBean

/**
 *  Created by HosseinBahrami at 1/19/2020
 */

@Database(entities = [GameBean::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun gameListDao(): GameListDao
    abstract  fun gameDetailsDao(): GameDetailsDao

    companion object {
        private lateinit var db: AppDatabase
        fun getInstance(context: Context): AppDatabase {
            db = Room.databaseBuilder(context, AppDatabase::class.java, "ViraDatabase")
                .allowMainThreadQueries().build()
            return db
        }
    }
}
package com.android.vira.databases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.vira.api.models.response.GameBean

/**
 *  Created by HosseinBahrami at 1/19/2020
 */

@Dao
interface GameDetailsDao {

    @Query("SELECT * FROM gamebean")
    fun getGameDetails(): GameBean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailsGame(vararg gameBean: GameBean)

}
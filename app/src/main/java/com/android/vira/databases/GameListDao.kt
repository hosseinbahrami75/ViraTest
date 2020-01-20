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
interface GameListDao {

    @Query("SELECT * FROM gamebean")
    fun getGameList(): List<GameBean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllGames(gameBean: List<GameBean>)

}
package com.android.vira.gameList

import android.content.Context
import com.android.vira.api.models.response.GameBean
import com.android.vira.databases.AppDatabase
import javax.inject.Singleton

/**
 *  Created by HosseinBahrami at 1/20/2020
 */

@Singleton
object GameListRepository {
    val data: MutableList<GameBean> = ArrayList()

    //Get games from appDatabase
    fun getLocalGameList(context: Context): List<GameBean> {
        data.addAll(AppDatabase.getInstance(context).gameListDao().getGameList())
        return data
    }
}
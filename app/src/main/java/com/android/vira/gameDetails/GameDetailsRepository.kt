package com.android.vira.gameDetails

import android.content.Context
import com.android.vira.api.models.response.GameBean
import com.android.vira.databases.AppDatabase
import javax.inject.Singleton

/**
 *  Created by HosseinBahrami at 1/20/2020
 */


@Singleton
object GameDetailsRepository {
    var data = GameBean()

    //get gameDetails from dataBase
    fun getLocalGameDetails(context: Context): GameBean {
        data = AppDatabase.getInstance(context).gameDetailsDao().getGameDetails()
        return data
    }

}
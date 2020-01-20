package com.android.vira.api

import com.android.vira.api.models.response.GameBean
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by HosseinBahrami at 1/19/2020
 */

interface ApiCall {

    //Get GamesList
    @GET("pnfbu")
    fun getGames(): Call<List<GameBean>>


    //Get GameDetails
    @GET("bjyoa")
    fun getGameDetails(): Call<GameBean>
}

package com.android.vira.gameDetails

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.vira.api.RetrofitCallBack
import com.android.vira.api.RetrofitClient
import com.android.vira.api.RetrofitObject
import com.android.vira.api.models.response.GameBean
import com.android.vira.databases.AppDatabase
import com.android.vira.utils.CheckNetwork

/**
 *  Created by HosseinBahrami at 1/20/2020
 */


class GameDetailsViewModel : ViewModel() {

    private var gameDetailsLiveData: MutableLiveData<GameBean> = MutableLiveData()

    fun getGameLiveDataDetails(loading: View?, context: Context): MutableLiveData<GameBean> {
        if (CheckNetwork.isNetworkAvailable(context)) {
            RetrofitCallBack.callRetrofit(
                RetrofitClient.getService().getGameDetails(),
                loading,
                object : RetrofitObject<GameBean> {
                    override fun onSuccess(body: GameBean) {
                        gameDetailsLiveData.value = body
                        AppDatabase.getInstance(context).gameDetailsDao().insertDetailsGame(body)
                    }

                    override fun onFailure(message: String) {
                        //TODO
                        Log.v("failedGames", message)
                    }
                })
        } else {
            gameDetailsLiveData.value = GameDetailsRepository.getLocalGameDetails(context)
        }
        return gameDetailsLiveData
    }

}
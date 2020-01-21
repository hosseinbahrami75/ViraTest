package com.android.vira.gameList

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
 *  Created by HosseinBahrami at 1/19/2020
 */

class GameListViewModel : ViewModel() {

    private var gamesData: MutableLiveData<List<GameBean>> = MutableLiveData()

    fun getLiveGamesData(loading: View?, context: Context): MutableLiveData<List<GameBean>> {
        if (CheckNetwork.isNetworkAvailable(context)) {
            RetrofitCallBack.callRetrofit(
                RetrofitClient.getService().getGames(),
                loading,
                object : RetrofitObject<List<GameBean>> {
                    override fun onSuccess(body: List<GameBean>) {
                        gamesData.value = body
                        GameListRepository.data.addAll(body)
                        if (AppDatabase.getInstance(context).gameListDao().getGameList().isNullOrEmpty()) {
                            AppDatabase.getInstance(context).gameListDao().insertAllGames(body)
                        }
                    }

                    override fun onFailure(message: String) {
                        //TODO
                        Log.v("failedGames", message)
                    }
                })
        } else {
            gamesData.value = GameListRepository.getLocalGameList(context)
        }
        return gamesData
    }


}
package com.android.vira.gameList

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.android.vira.api.RetrofitCallBack
import com.android.vira.api.RetrofitClient
import com.android.vira.api.RetrofitObject
import com.android.vira.api.models.response.GameBean
import com.android.vira.databases.AppDatabase
import javax.inject.Singleton

@Singleton
object GameListRepository {

    fun getGameList(context: Context, loading: View?): MutableLiveData<List<GameBean>> {
        val data = MutableLiveData<List<GameBean>>()
        RetrofitCallBack.callRetrofit(RetrofitClient.getService().getGames(), loading, object: RetrofitObject<List<GameBean>> {
            override fun onSuccess(body: List<GameBean>) {
                data.value = body
                AppDatabase.getInstance(context).gameListDao().insertAllGames(body)
            }

            override fun onFailure(message: String) {
                //TODO
            }
        })
        return data
    }
}
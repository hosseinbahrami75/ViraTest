package com.android.vira.gameList

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.vira.api.models.response.GameBean

/**
 *  Created by HosseinBahrami at 1/19/2020
 */

class GameListViewModel: ViewModel() {

    fun getLiveGamesData(loading: View?, context: Context): MutableLiveData<List<GameBean>> {
        return GameListRepository.getGameList(context, loading)
    }

}
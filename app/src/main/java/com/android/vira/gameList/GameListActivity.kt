package com.android.vira.gameList

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.vira.R
import com.android.vira.databases.AppDatabase
import com.android.vira.utils.BaseActivity
import kotlinx.android.synthetic.main.activity_game_list.*

/**
 *  Created by HosseinBahrami at 1/19/2020
 */

class GameListActivity : BaseActivity() {

    private lateinit var gameListViewModel: GameListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_list)

        gameListViewModel = ViewModelProviders.of(this).get(GameListViewModel::class.java)
        getData()
    }


    private fun getData() {
        if (inNetworkConnected()) {
            gameListViewModel.getLiveGamesData(loading, this).observe(this, Observer {
                showShortToast(it.size.toString())
            })
        } else {
            showShortToast(AppDatabase.getInstance(this).gameListDao().getGameList().size.toString())
        }
    }
}

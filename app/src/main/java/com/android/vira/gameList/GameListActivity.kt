package com.android.vira.gameList

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.vira.R
import com.android.vira.adapters.GameListAdapter
import com.android.vira.api.models.response.GameBean
import com.android.vira.databinding.ActivityGameListBinding
import com.android.vira.utils.BaseActivity
import kotlinx.android.synthetic.main.activity_game_list.*

/**
 *  Created by HosseinBahrami at 1/19/2020
 */

class GameListActivity : BaseActivity() {
    private lateinit var gameListViewModel: GameListViewModel
    private var gameList = mutableListOf<GameBean>()
    private lateinit var binding: ActivityGameListBinding
    private lateinit var gamesAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_list)
        gameListViewModel = ViewModelProviders.of(this).get(GameListViewModel::class.java)
        initGamesAdapter()
        getData()
    }

    private fun getData() {
        gameListViewModel.getLiveGamesData(loading, this).observe(this, Observer {
            gameList.addAll(it)
            if (gameList.isNullOrEmpty())
                showShortToast("برای گرفتن دیتا باید یکبار به نت وصل شوید")
            else
                binding.gameLisRecycler.adapter!!.notifyDataSetChanged()
        })
    }


    private fun initGamesAdapter() {
        gamesAdapter = GameListAdapter(this, gameList)
        binding.gameLisRecycler.adapter = gamesAdapter
        binding.gameLisRecycler.adapter!!.notifyDataSetChanged()
    }



}

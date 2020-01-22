package com.android.vira.gameDetails

import android.os.Bundle
import android.widget.MediaController
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.vira.R
import com.android.vira.api.models.response.GameBean
import com.android.vira.databinding.ActivityGameDetailsBinding
import com.android.vira.utils.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_game_details.*

/**
 *  Created by HosseinBahrami at 1/20/2020
 */


class GameDetailsActivity : BaseActivity() {
    private lateinit var gameDetailsViewModel: GameDetailsViewModel
    private lateinit var binding: ActivityGameDetailsBinding
    private lateinit var gameBean: GameBean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_details)
        gameDetailsViewModel = ViewModelProviders.of(this).get(GameDetailsViewModel::class.java)

        getData()
    }


    private fun getData() {
        gameDetailsViewModel.getGameLiveDataDetails(loading, this).observe(this, Observer {
            gameBean = it

            binding.movieName.text = gameBean.title
            binding.description.text = gameBean.description
            binding.rate.rating = gameBean.rate.toFloat()
            binding.playersCount.text = gameBean.playerCount.toString()
            binding.genreName.text = gameBean.genre.genreName

            Picasso.get().load(gameBean.image).into(binding.imgGames)
            Picasso.get().load(gameBean.genre.genreImage).into(binding.imgGenre)

            binding.videoView.setVideoPath(gameBean.video)
            val mediaController = MediaController(this)
            mediaController.setAnchorView(binding.videoView)
            binding.videoView.setMediaController(mediaController)
            binding.videoView.setOnPreparedListener {
                binding.videoView.start()
            }
            binding.videoView.setOnCompletionListener { binding.videoView.start() }

        })
    }
}

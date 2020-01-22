package com.android.vira.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.vira.adapters.callBacks.GameClickCallBack
import com.android.vira.api.models.response.GameBean
import com.android.vira.databinding.ItemGamesBinding
import org.greenrobot.eventbus.EventBus

/**
 *  Created by HosseinBahrami at 1/19/2020
 */

class GameListAdapter(private var games: List<GameBean>) :
    RecyclerView.Adapter<GameListAdapter.GamesViewHolder>() {
    init {
        setHasStableIds(true)
    }

    inner class GamesViewHolder(
        private val binding: ItemGamesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GameBean) {
            binding.data = item
            binding.rate.rating = item.rate.toFloat()
            binding.playersCount.text = item.playerCount.toString()
            binding.game.setOnClickListener { EventBus.getDefault().post(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGamesBinding.inflate(inflater)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int = games.size
    override fun getItemViewType(position: Int): Int = position
    override fun getItemId(position: Int): Long = games[position].id.toLong()

}
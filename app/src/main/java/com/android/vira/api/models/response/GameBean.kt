package com.android.vira.api.models.response

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class GameBean(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "rate") val rate: String,
    @ColumnInfo(name = "players_count") @SerializedName("players_count") val playerCount: Int,
    @Embedded val genre: GenreBean,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "video") val video: String
)
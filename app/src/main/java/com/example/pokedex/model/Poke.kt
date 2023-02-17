package com.example.pokedex.model

import android.media.Image
import com.google.gson.annotations.SerializedName

data class Poke(
    @SerializedName("name")val text: String,
    val id: Int,
    )

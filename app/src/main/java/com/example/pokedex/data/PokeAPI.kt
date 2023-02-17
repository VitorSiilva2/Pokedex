package com.example.pokedex.data

import com.example.pokedex.model.Poke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPI {
    @GET ("pokemon/{id}")
    fun findAllPoke(@Path("id") id : Int) : Call<Poke>
}
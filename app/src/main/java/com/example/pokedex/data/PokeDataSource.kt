package com.example.pokedex.data

import android.util.Log
import com.example.pokedex.model.Poke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException

class PokeDataSource {
    fun findAllPoke(id : Int, callBack : ListCategoryCallBack)   {
        HTTPClient.retrofit()
            .create(PokeAPI::class.java)
            .findAllPoke(id)
            .enqueue(object : Callback<Poke> {
                override fun onResponse(call: Call<Poke>, response: Response<Poke>) {
                    if (response.isSuccessful) {
                        val poke = response.body()
                        callBack.onSuccess( poke ?: throw RuntimeException("Pokemon não encontrado"), id)
                        callBack.onComplete()

                    } else {
                        val error = response.errorBody()?.toString()
                        callBack.onError(error?: "Error")
                        callBack.onComplete()
                    }
                }

                override fun onFailure(call: Call<Poke>, t: Throwable) {
                    Log.e("MainActivity", "Erro ao obter dados: ${t.message}")
                    callBack.onError(t.message ?: "Erro")
                    callBack.onComplete()

                }

            })
    }
}
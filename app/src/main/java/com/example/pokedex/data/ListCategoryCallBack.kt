package com.example.pokedex.data

import com.example.pokedex.model.Poke

interface ListCategoryCallBack {

    fun onSuccess (response: Poke, id: Int)

    fun onError(response : String)

    fun onComplete()
}
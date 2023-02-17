package com.example.pokedex.presentation

import com.example.pokedex.data.PokeDataSource
import com.example.pokedex.data.ListCategoryCallBack
import com.example.pokedex.model.Poke
import com.example.pokedex.view.MainActivity

class PokePresenter (
    private val view : MainActivity,
    private val dataSource: PokeDataSource = PokeDataSource()

    ) : ListCategoryCallBack {

        fun findAllPoke(id : Int) {
            dataSource.findAllPoke(id,this )
        }

        override fun onSuccess(response: Poke, id: Int) {
            view.showPoke(id, response)
        }

        override fun onError(response: String) {
            view.showFailure(response)
        }

        override fun onComplete() {
        }
    }

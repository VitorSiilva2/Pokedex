package com.example.pokedex.view

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.presentation.PokePresenter
import com.example.pokedex.R
import com.example.pokedex.data.HTTPClient
import com.example.pokedex.model.Poke
import com.example.pokedex.model.Pokemon
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieAdapter
import java.util.logging.LogRecord
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: PokePresenter

    private lateinit var adapter: GroupieAdapter
    private lateinit var listPoke : MutableList<Pokemon>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_main)

        presenter = PokePresenter(this)



        for (i in 1..50) {
        presenter.findAllPoke(i)
        }

        listPoke = mutableListOf()
        adapter = GroupieAdapter()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter



    }


        fun showPoke(id : Int, Response: Poke) {

                val pokemon = Pokemon(
                    id,
                    Response.text,
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
                )
                listPoke.add(pokemon)

            adapter.add(CategoryItem(pokemon))



        }

        fun showProgress() {
        }

        fun hideProgress() {
        }

        fun showFailure(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
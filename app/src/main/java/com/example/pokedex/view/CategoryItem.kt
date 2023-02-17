package com.example.pokedex.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.pokedex.R
import com.example.pokedex.model.Poke
import com.example.pokedex.model.Pokemon
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CategoryItem(private val pokemon: Pokemon) : Item<CategoryItem.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : GroupieViewHolder(view)

    override fun createViewHolder(itemView: View): CategoryViewHolder {
        return CategoryViewHolder(itemView)
    }

    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.name_pokemon).text = pokemon.name
        Picasso.get().load(pokemon.imageUrl).into(viewHolder.itemView.findViewById<ImageView>(R.id.image_pokemon))
    }

    override fun getLayout(): Int {
        return R.layout.main_item
    }
}

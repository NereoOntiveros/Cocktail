package com.nereoontiveros.cocktail.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nereoontiveros.cocktail.R
import com.nereoontiveros.cocktail.base.BaseViewHolder
import com.nereoontiveros.cocktail.data.model.Drink
import kotlinx.android.synthetic.main.drinks_row.view.*


class MainAdapter(private val context: Context, private val drinksList: List<Drink>,
        private val itemClickListener: OnDrinkClickListener) :

    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnDrinkClickListener{
        fun onDrinkClick(drink:Drink)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.drinks_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return drinksList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(drinksList[position], position)
        }
    }

    inner class MainViewHolder(itemView: View) : BaseViewHolder<Drink>(itemView) {
        override fun bind(item: Drink, position: Int) {
            Glide.with(context).load(item.image).centerCrop().into(itemView.img_drink)
            itemView.txt_title.text = item.name
            itemView.txt_description.text = item.description
            itemView.setOnClickListener{ itemClickListener.onDrinkClick(item)}
        }

    }


}
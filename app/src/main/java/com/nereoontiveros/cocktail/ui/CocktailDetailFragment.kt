package com.nereoontiveros.cocktail.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nereoontiveros.cocktail.R
import com.nereoontiveros.cocktail.data.model.Drink


class CocktailDetailFragment : Fragment() {

    private lateinit var drink:Drink

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable<Drink>("drink")!!

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cocktail_detail, container, false)
    }


}
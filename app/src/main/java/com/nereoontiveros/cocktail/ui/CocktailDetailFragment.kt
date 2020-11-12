package com.nereoontiveros.cocktail.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.nereoontiveros.cocktail.R
import com.nereoontiveros.cocktail.data.model.Drink
import kotlinx.android.synthetic.main.fragment_cocktail_detail.*


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(drink.image).centerCrop().into(image_drink)
        tv_drink_title.text=drink.name
        tv_drink_description.text=drink.description

    }
}
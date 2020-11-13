package com.nereoontiveros.cocktail.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.nereoontiveros.cocktail.AppDataBase
import com.nereoontiveros.cocktail.R
import com.nereoontiveros.cocktail.data.DataSource
import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.data.model.DrinkEntity
import com.nereoontiveros.cocktail.domain.RepoImpl
import com.nereoontiveros.cocktail.ui.viewmodel.MainViewModel
import com.nereoontiveros.cocktail.ui.viewmodel.VMFactory
import kotlinx.android.synthetic.main.fragment_cocktail_detail.*


class CocktailDetailFragment : Fragment() {
    private val viewModel by viewModels<MainViewModel> { VMFactory(
        RepoImpl(
            DataSource(AppDataBase.getDataBase(requireActivity().applicationContext))))  }//dependencies injection
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

        btn_save_drink.setOnClickListener {
            viewModel.saveDrink(DrinkEntity(drink.drinkId,drink.image,drink.name,drink.description,drink.typeOfDrink))
            Toast.makeText(requireContext(),"Added to Favourites",Toast.LENGTH_SHORT).show()
        }

    }
}
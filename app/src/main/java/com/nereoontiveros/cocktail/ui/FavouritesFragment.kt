package com.nereoontiveros.cocktail.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.nereoontiveros.cocktail.AppDataBase
import com.nereoontiveros.cocktail.R
import com.nereoontiveros.cocktail.data.DataSource
import com.nereoontiveros.cocktail.domain.RepoImpl
import com.nereoontiveros.cocktail.ui.viewmodel.MainViewModel
import com.nereoontiveros.cocktail.ui.viewmodel.VMFactory
import com.nereoontiveros.cocktail.vo.Resource

class FavouritesFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel> { VMFactory(
        RepoImpl(
            DataSource(AppDataBase.getDataBase(requireActivity().applicationContext))
        )
    )  }//dependencies injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFavouriteDrinks().observe(viewLifecycleOwner, Observer { result->
            when(result){
                is Resource.Loading->{

                }
                is Resource.Success->{
                    Log.d("LISTA_FAVORITOS: ","${result.data}")
                }
                is Resource.Failure->{

                }
            }
        })
    }


}
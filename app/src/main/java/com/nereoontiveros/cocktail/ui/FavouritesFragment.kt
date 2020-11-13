package com.nereoontiveros.cocktail.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nereoontiveros.cocktail.AppDataBase
import com.nereoontiveros.cocktail.R
import com.nereoontiveros.cocktail.data.DataSource
import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.data.model.DrinkEntity
import com.nereoontiveros.cocktail.domain.RepoImpl
import com.nereoontiveros.cocktail.ui.viewmodel.MainViewModel
import com.nereoontiveros.cocktail.ui.viewmodel.VMFactory
import com.nereoontiveros.cocktail.vo.Resource
import kotlinx.android.synthetic.main.fragment_favourites.*

class FavouritesFragment : Fragment(),MainAdapter.OnDrinkClickListener {

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
        setupRecyclerView()
        setupObservers()

    }

    private fun setupObservers(){
        viewModel.getFavouriteDrinks().observe(viewLifecycleOwner, Observer { result->
            when(result){
                is Resource.Loading->{

                }
                is Resource.Success->{
                    val drinksList:List<Drink> = result.data.map{
                        Drink(it.drinkId,it.image,it.name,it.description,it.typeOfDrink)
                    }
                    rv_favourites.adapter=MainAdapter(requireContext(),drinksList,this)
                }
                is Resource.Failure->{

                }
            }
        })
    }

    private fun setupRecyclerView(){
        rv_favourites.layoutManager = LinearLayoutManager(requireContext())
        rv_favourites.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }




    override fun onDrinkClick(drink: Drink,position:Int){
        viewModel.deleteDrink(drink)
        rv_favourites.adapter?.notifyItemRemoved(position)
        rv_favourites.adapter?.notifyItemRangeRemoved(position,rv_favourites.adapter?.itemCount!!)
    }




}
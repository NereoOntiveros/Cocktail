package com.nereoontiveros.cocktail.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nereoontiveros.cocktail.AppDataBase
import com.nereoontiveros.cocktail.R
import com.nereoontiveros.cocktail.data.DataSource
import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.domain.RepoImpl
import com.nereoontiveros.cocktail.ui.viewmodel.MainViewModel
import com.nereoontiveros.cocktail.ui.viewmodel.VMFactory
import com.nereoontiveros.cocktail.vo.Resource
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(),MainAdapter.OnDrinkClickListener{

    private val viewModel by viewModels<MainViewModel> { VMFactory(
        RepoImpl(
            DataSource(AppDataBase.getDataBase(requireActivity().applicationContext))))  }//dependencies injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupSearchView()
        setupObservers()
        btn_go_favourites.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_favouritesFragment)
        }
    }

    private fun setupObservers(){
        viewModel.fetchDrinksList.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                    rv_drinks.adapter = MainAdapter(requireContext(),result.data,this)
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "An error occurred when fetching data ${result.exception}.", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setupSearchView(){
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.setDrink(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun setupRecyclerView(){
        rv_drinks.layoutManager=LinearLayoutManager(requireContext())
        rv_drinks.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }

    override fun onDrinkClick(drink: Drink) {
        val bundle = Bundle()
        bundle.putParcelable("drink",drink)
        findNavController().navigate(R.id.action_mainFragment_to_cocktailDetailFragment,bundle)
    }


}
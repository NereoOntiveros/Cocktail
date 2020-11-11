package com.nereoontiveros.cocktail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.nereoontiveros.cocktail.data.DataSource
import com.nereoontiveros.cocktail.domain.RepoImpl
import com.nereoontiveros.cocktail.ui.viewmodel.MainViewModel
import com.nereoontiveros.cocktail.ui.viewmodel.VMFactory

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSource()))  }//dependencies injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //navController controls all the navigation within the app
        navController = findNavController(R.id.nav_host_fragment)
        //set the actionbar to get back
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

}
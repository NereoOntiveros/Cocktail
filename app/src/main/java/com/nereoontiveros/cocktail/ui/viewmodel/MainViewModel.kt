package com.nereoontiveros.cocktail.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nereoontiveros.cocktail.domain.Repo
import com.nereoontiveros.cocktail.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlin.Exception

class MainViewModel(private val repo:Repo):ViewModel() {

    val fetchDrinksList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getDrinksList())
        }catch (e:Exception){
            //emit(Resource.Failure(e))
        }
    }
}
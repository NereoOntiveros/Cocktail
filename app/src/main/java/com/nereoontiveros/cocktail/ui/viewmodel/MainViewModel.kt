package com.nereoontiveros.cocktail.ui.viewmodel

import androidx.lifecycle.*
import com.nereoontiveros.cocktail.domain.Repo
import com.nereoontiveros.cocktail.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlin.Exception

class MainViewModel(private val repo:Repo):ViewModel() {

    private val drinksData = MutableLiveData<String>()

    fun setDrink(drinkName:String){
        drinksData.value = drinkName
    }

    init {
        setDrink("margarita")
    }

    val fetchDrinksList = drinksData.distinctUntilChanged().switchMap {nameDrink->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getDrinksList(nameDrink))
            }catch (e:Exception){
                //emit(Resource.Failure(e))
            }
        }
    }
}
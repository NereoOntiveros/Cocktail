package com.nereoontiveros.cocktail.ui.viewmodel

import androidx.lifecycle.*
import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.data.model.DrinkEntity
import com.nereoontiveros.cocktail.domain.Repo
import com.nereoontiveros.cocktail.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    fun saveDrink(drink:DrinkEntity){
        viewModelScope.launch {
            repo.insertDrink(drink)
        }
    }

    fun deleteDrink(drink: Drink){
        viewModelScope.launch {
            repo.deleteDrink(drink)
        }
    }

    fun getFavouriteDrinks()= liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getFavouriteDrinks())
        }catch (e:Exception){
            //emit(Resource.Failure(e))
        }
    }
}
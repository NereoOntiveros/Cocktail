package com.nereoontiveros.cocktail.data

import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.vo.Resource
import com.nereoontiveros.cocktail.vo.RetrofitClient

class DataSource {

    suspend fun getDrinkByName(drinkName:String):Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.webservice.getCocktailByName(drinkName).drinkList)
    }




}
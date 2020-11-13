package com.nereoontiveros.cocktail.data

import android.util.Log
import com.nereoontiveros.cocktail.AppDataBase
import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.data.model.DrinkEntity
import com.nereoontiveros.cocktail.vo.Resource
import com.nereoontiveros.cocktail.vo.RetrofitClient

class DataSource (private val appDataBase: AppDataBase){

    suspend fun getDrinkByName(drinkName:String):Resource<List<Drink>>{

        return Resource.Success(RetrofitClient.webservice.getCocktailByName(drinkName).drinkList)
    }

    suspend fun saveDrinkIntoRoom(drink:DrinkEntity){
        appDataBase.drinkDao().insertFavourite(drink)
    }

    suspend fun getFavouriteDrinks(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDataBase.drinkDao().getAllFavouriteDrinks())
    }

    suspend fun deleteDrink(drink:Drink){
        appDataBase.drinkDao().deleteDrink(drink)
    }

}
package com.nereoontiveros.cocktail.domain

import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.data.model.DrinkEntity
import com.nereoontiveros.cocktail.vo.Resource

interface Repo {

    suspend fun getDrinksList(drinkName:String):Resource<List<Drink>>
    suspend fun getFavouriteDrinks():Resource<List<DrinkEntity>>
    suspend fun insertDrink(drink:DrinkEntity)
    suspend fun deleteDrink(drink: Drink)
}
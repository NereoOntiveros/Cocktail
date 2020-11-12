package com.nereoontiveros.cocktail.domain

import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.vo.Resource

interface Repo {

    suspend fun getDrinksList(drinkName:String):Resource<List<Drink>>
}
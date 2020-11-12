package com.nereoontiveros.cocktail.domain

import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("search.php")
    suspend fun getCocktailByName(@Query(value = "s") cocktailName:String):DrinkList
}
package com.nereoontiveros.cocktail.domain

import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("search.php?s=")
    suspend fun getCocktailByName(@Query("cocktailName") cocktailName:String):DrinkList
}
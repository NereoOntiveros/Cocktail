package com.nereoontiveros.cocktail.domain

import androidx.room.*
import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.data.model.DrinkEntity

@Dao
interface DrinksDao {
    @Query("SELECT * FROM cocktailsEntity")
    suspend fun getAllFavouriteDrinks():List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavourite(drink:DrinkEntity)

    @Delete
    suspend fun deleteDrink(drink: DrinkEntity)
}
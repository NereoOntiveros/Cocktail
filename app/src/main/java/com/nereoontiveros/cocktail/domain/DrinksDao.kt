package com.nereoontiveros.cocktail.domain

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nereoontiveros.cocktail.data.model.DrinkEntity


interface DrinksDao {
    @Query("SELECT * FROM cocktailsEntity")
    suspend fun getAllFavouriteDrinks():List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavourite(drink:DrinkEntity)
}
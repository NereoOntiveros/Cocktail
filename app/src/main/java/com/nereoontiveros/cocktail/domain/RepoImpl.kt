package com.nereoontiveros.cocktail.domain

import com.nereoontiveros.cocktail.data.DataSource
import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.data.model.DrinkEntity
import com.nereoontiveros.cocktail.vo.Resource

class RepoImpl(private val dataSource: DataSource):Repo {

    suspend override fun getDrinksList(drinkName:String): Resource<List<Drink>> {
        return dataSource.getDrinkByName(drinkName)
    }

    override suspend fun getFavouriteDrinks(): Resource<List<DrinkEntity>> {
        return dataSource.getFavouriteDrinks()
    }

    override suspend fun insertDrink(drink: DrinkEntity) {
        dataSource.saveDrinkIntoRoom(drink)
    }
}
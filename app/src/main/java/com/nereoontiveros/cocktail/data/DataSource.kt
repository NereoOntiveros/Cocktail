package com.nereoontiveros.cocktail.data

import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.vo.Resource

class DataSource {
    private val generateDrinksList = listOf(
        Drink("https://makemeacocktail.com/images/cocktails/6865/san_fransisco.jpg", "san francisco", "con zumo de tomate"),
        Drink("https://www.jamieoliver.com/drinks-tube/app/uploads/2014/06/Margarita.jpg", "margarita", "con azucar y vodka"),
        Drink("https://images.clarin.com/2020/04/07/fernet-con-cola-foto-instagram___N-oobYIWz_340x340__1.jpg", "fernet", "fernet pepsi"),
        Drink("https://i.pinimg.com/originals/60/d1/db/60d1db4b96bb8ec5ee00a40cb2bda4d9.jpg","toro","vino con lo que sea")
    )

    fun getDrinksList(): Resource<List<Drink>>{
        return Resource.Success(generateDrinksList)
    }
}
package com.nereoontiveros.cocktail.domain

import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.vo.Resource

interface Repo {

    fun getDrinksList():Resource<List<Drink>>
}
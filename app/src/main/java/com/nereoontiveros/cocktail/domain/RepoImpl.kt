package com.nereoontiveros.cocktail.domain

import com.nereoontiveros.cocktail.data.DataSource
import com.nereoontiveros.cocktail.data.model.Drink
import com.nereoontiveros.cocktail.vo.Resource

class RepoImpl(private val dataSource: DataSource):Repo {
    override fun getDrinksList(): Resource<List<Drink>> {
        return dataSource.getDrinksList()
    }
}
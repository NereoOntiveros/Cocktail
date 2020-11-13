package com.nereoontiveros.cocktail

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nereoontiveros.cocktail.data.model.DrinkEntity
import com.nereoontiveros.cocktail.domain.DrinksDao

@Database(entities = arrayOf(DrinkEntity::class),version=1)
abstract class AppDataBase :RoomDatabase(){

    abstract fun drinkDao(): DrinksDao

    companion object{
        //singleton
        private var INSTANCE:AppDataBase?=null

        fun getDataBase(context: Context):AppDataBase{
            INSTANCE = INSTANCE ?: Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, "drinks_table").build()
            return INSTANCE!!
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }

}
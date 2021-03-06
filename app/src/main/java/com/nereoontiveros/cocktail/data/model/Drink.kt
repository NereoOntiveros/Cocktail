package com.nereoontiveros.cocktail.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Drink(
    @SerializedName("idDrink")
    val drinkId:String = "",
    @SerializedName("strDrinkThumb")
    val image: String = "",
    @SerializedName("strDrink")
    val name: String = "",
    @SerializedName("strInstructions")
    val description: String = "",
    @SerializedName("strAlcoholic")
    val typeOfDrink:String ="Non_Alcoholic"
):Parcelable

data class DrinkList(
    @SerializedName("drinks")
    val drinkList:List<Drink>)

@Entity(tableName = "cocktailsEntity")
data class DrinkEntity(
    @PrimaryKey
    val drinkId: String,
    @ColumnInfo(name="drink_image")
    val image: String = "",
    @ColumnInfo(name="drink_name")
    val name: String = "",
    @ColumnInfo(name = "drink_description")
    val description: String = "",
    @ColumnInfo(name = "drink_has_alcohol")
    val typeOfDrink:String ="Non_Alcoholic"
)

fun Drink.asDrinkEntity():DrinkEntity=
    DrinkEntity(this.drinkId,this.image,this.name,this.description,this.typeOfDrink)
package dev.lchang.appue.data.local

import FavoriteCountryEntity
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCountryDao {
    // PARA consultar todas las entidades, insertar, eleimianr etc
    // Insert FavoriteCountryEntity
    @Insert
    suspend fun insertFavoriteCountry(favoriteCountry: FavoriteCountryEntity)

    //Delete FavoriteCountryEntity
    @Delete
    suspend fun deleteFavoriteCountry(favoriteCountry: FavoriteCountryEntity)

    //Query
    @Query("SELECT * FROM favorite_countries")
    fun getAll(): Flow<List<FavoriteCountryEntity>>




}
package dev.lchang.appue.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface FavoriteCountryDao {
    // Insert FavoriteCountryEntity
    @Insert
    suspend fun insertFavoriteCountry(favoriteCountry: FavoriteCountryEntity)

    //Delete FavoriteCountryEntity
    @Delete
    suspend fun deleteFavoriteCountry(favoriteCountry: FavoriteCountryEntity)

    //Query
    @Query("SELECT * FROM favorite_countries")
    suspend fun getAll(): Flow<List<FavoriteCountryEntity>>
}

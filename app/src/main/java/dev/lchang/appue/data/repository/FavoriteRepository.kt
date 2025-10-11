package dev.lchang.appue.data.repository

import FavoriteCountryEntity
import dev.lchang.appue.data.local.FavoriteCountryDao
import kotlinx.coroutines.flow.Flow

class FavoriteRepository ( private val dao: FavoriteCountryDao) {
    // recibimos la entidad que hemos creado
    suspend fun insert(country: FavoriteCountryEntity)
    =dao.insertFavoriteCountry(country)

    suspend fun delete(country: FavoriteCountryEntity)
    =dao.deleteFavoriteCountry(country)

    fun getAll(): Flow<List<FavoriteCountryEntity>>
    = dao.getAll()



}

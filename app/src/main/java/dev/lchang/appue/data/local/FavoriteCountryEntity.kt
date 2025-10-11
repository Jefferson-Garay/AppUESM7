package dev.lchang.appue.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_countries")
data class FavoriteCountryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val Ranking: Int,
    val imagenUrl: String
)




// Agrgar dependecias buld. gradle.kts
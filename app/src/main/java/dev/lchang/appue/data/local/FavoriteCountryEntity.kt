package dev.lchang.appue.data.local

data class FavoriteCountryEntity(
    val id: Int = 0,
    val name: String,
    val Ranking: Int,
    val imagenUrl: String
)

// Agrgar dependecias buld. gradle.kts
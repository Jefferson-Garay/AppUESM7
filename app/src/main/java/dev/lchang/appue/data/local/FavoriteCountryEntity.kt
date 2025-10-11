import androidx.room.Entity
import androidx.room.PrimaryKey

data class FavoriteCountryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val Ranking: Int,
    val imagenUrl: String
)

// Agrgar dependecias buld. gradle.kts
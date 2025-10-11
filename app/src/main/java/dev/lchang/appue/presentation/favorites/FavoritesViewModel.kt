package dev.lchang.appue.presentation.favorites

import FavoriteCountryEntity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.lchang.appue.data.repository.FavoriteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoritesViewModel
    (private val repository: FavoriteRepository) : ViewModel() {

    val favorites: StateFlow<List<FavoriteCountryEntity>>
    = repository.getAll().stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )



    fun insertFavorite(country: FavoriteCountryEntity){
        viewModelScope.launch {
            repository.insert(country)
        }
    }

    fun deleteFavorite(country: FavoriteCountryEntity){
        viewModelScope.launch {
            repository.delete(country)
        }
    }
}


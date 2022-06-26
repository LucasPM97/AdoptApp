package com.lucas.adoptapp.ui.screens.home

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.core.data.models.PetItem
import com.lucas.core.data.remote.responses.Response
import com.lucas.core.data.repositories.IPetsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: IPetsRepository
) : ViewModel() {

    private var newestPetsJob: Job? = null
    private val _newestPetsUiState = MutableStateFlow(
        NewestPetsUiState(
            loading = false,
            pets = emptyList()
        )
    )
    val newestPetsUiState = _newestPetsUiState.asStateFlow()

    private var nearPetsJob: Job? = null
    private val _nearPetsUiState = MutableStateFlow(
        NearPetsUiState(
            loading = false,
            pets = emptyList()
        )
    )
    val nearPetsUiState = _nearPetsUiState.asStateFlow()


    init {
        loadNewestPetList()
        loadNearPetList()
    }

    fun loadNewestPetList() {

        if (newestPetsUiState.value.loading) return

        _newestPetsUiState.update {
            it.copy(
                loading = true
            )
        }

        newestPetsJob?.cancel()
        newestPetsJob = viewModelScope.launch {

            val response = repository.getRecentNearPets()

            when (response) {
                is Response.Success -> {

                    val pets = response.data

                    pets?.let {
                        _newestPetsUiState.update {
                            it.copy(
                                pets = pets
                            )
                        }
                    }
                }
                is Response.Error -> {
                    //TODO: Add error message
//                    _newestPetsUiState.update {
//                        it.copy(
//                            errorStringId = R.string.error_loading_pokemon_list
//                        )
//                    }
                }
            }

            _newestPetsUiState.update {
                it.copy(
                    loading = false
                )
            }
        }
    }

    fun loadNearPetList() {

        if (nearPetsUiState.value.loading) return

        _nearPetsUiState.update {
            it.copy(
                loading = true
            )
        }

        nearPetsJob?.cancel()
        nearPetsJob = viewModelScope.launch {

            val response = repository.getNearPets()

            when (response) {
                is Response.Success -> {

                    val pets = response.data

                    pets?.let {
                        _nearPetsUiState.update {
                            it.copy(
                                pets = nearPetsUiState.value.pets + pets
                            )
                        }
                    }
                }
                is Response.Error -> {
                    //TODO: Add error message
//                    _newestPetsUiState.update {
//                        it.copy(
//                            errorStringId = R.string.error_loading_pokemon_list
//                        )
//                    }
                }
            }

            _nearPetsUiState.update {
                it.copy(
                    loading = false
                )
            }
        }
    }

}

data class NearPetsUiState(
    val pets: List<PetItem>,
    val loading: Boolean = false,
    @StringRes val errorStringId: Int? = null
)

data class NewestPetsUiState(
    val pets: List<PetItem>,
    val loading: Boolean = false,
    @StringRes val errorStringId: Int? = null
)
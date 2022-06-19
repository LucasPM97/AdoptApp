package com.lucas.adoptapp.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucas.adoptapp.ui.screens.home.HomeViewModel
import com.lucas.core.data.repositories.PetsRepository
import com.lucas.core.mocks.MockPetsDataSource

class HomeViewModelFactory() : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(
            PetsRepository(
                MockPetsDataSource()
            )
        ) as T
    }
}
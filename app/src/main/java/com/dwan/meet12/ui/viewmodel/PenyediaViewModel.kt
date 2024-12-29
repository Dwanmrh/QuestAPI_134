package com.dwan.meet12.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.dwan.meet12.MahasiswaApplications

object PenyediaViewModel{
    val Factory = viewModelFactory{
        initializer { HomeViewModel(MahasiswaApplications().container.mahasiswaRepository) }
        initializer { InsertViewModel(MahasiswaApplications().container.mahasiswaRepository) }
        initializer { UpdateViewModel(MahasiswaApplications().container.mahasiswaRepository) }
        initializer { DetailViewModel(MahasiswaApplications().container.mahasiswaRepository) }
    }

    fun CreationExtras.MahasiswaApplications(): MahasiswaApplications =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as MahasiswaApplications)
}
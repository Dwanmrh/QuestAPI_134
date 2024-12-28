package com.dwan.meet12.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dwan.meet12.model.Mahasiswa
import com.dwan.meet12.repository.MahasiswaRepository
import kotlinx.coroutines.launch

// ViewModel untuk mengatur data dan logika form tambah mahasiswa
class InsertViewModel(private val mhs: MahasiswaRepository): ViewModel() {

    // Data untuk menyimpan keadaan form (seperti input dari pengguna)
    var uiState by mutableStateOf(InsertUiState())
    private set

    // Fungsi untuk mengubah data form ketika ada input dari pengguna
    fun updateInsertMhsState(insertUiEvent.InsertUiEvent) {
        uiState = InsertUiState(insertUiEvent = insertUiEvent) // Perbarui data berdasarkan event
    }

    // Fungsi untuk menambahkan data mahasiswa ke database
    suspend fun insertMhs() {
        viewModelScope.launch { // Menjalankan proses di latar belakang (tidak mengganggu UI)
            try {
                // Mengambil data dari form dan mengirimnya ke repository
                mhs.insertMahasiswa(uiState.insertUiEvent.toMhs())
            }catch (e:Exception) {
                e.printStackTrace() // Menangani error jika terjadi masalah
            }
        }
    }
}

// Fungsi untuk mengubah data Mahasiswa menjadi data InsertUiEvent
fun Mahasiswa.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
    nim = nim, // Memindahkan nilai NIM dari Mahasiswa ke InsertUiEvent
    nama = nama,
    alamat = alamat,
    jenisKelamin = jenisKelamin,
    kelas = kelas,
    angkatan = angkatan
)
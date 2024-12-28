package com.dwan.meet12.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dwan.meet12.ui.navigation.DestinasiNavigasi
import com.dwan.meet12.ui.viewmodel.InsertUiEvent
import com.dwan.meet12.ui.viewmodel.InsertViewModel
import com.dwan.meet12.ui.viewmodel.PenyediaViewModel

// Membuat objek `DestinasiEntry` yang mengimplementasikan interface `DestinasiNavigasi`
object DestinasiEntry : DestinasiNavigasi {

    // Mendefinisikan properti `route` yang mengacu pada string "item_entry"
    override val route = "item_entry"

    // Mendefinisikan properti `titleRes` yang mengacu pada string "Entry Mhs"
    override val titleRes = "Entry Mhs"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryMhsScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: InsertViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    // Membuat coroutine scope untuk operasi asynchronous di dalam composable ini
    val coroutineScope = rememberCoroutineScope()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(
    insertUiEvent: InsertUiEvent, // Parameter yang digunakan untuk menyimpan data atau event input
    modifier: Modifier = Modifier,
    onValueChange: (InsertUiEvent) -> Unit = {}, // Lambda untuk menangani perubahan nilai input
    enabled: Boolean = true // Parameter untuk mengontrol apakah input dapat diubah atau tidak (default: true)
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Input teks untuk "Nama"
        OutlinedTextField(
            value = insertUiEvent.nama,  // Nilai saat ini dari input "Nama"
            onValueChange = { onValueChange(insertUiEvent.copy(nama = it)) }, // Mengubah nilai "Nama" dalam `insertUiEvent`
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled, // Input aktif atau nonaktif sesuai parameter
            singleLine = true // Hanya satu baris teks
        )
        // Input teks untuk "NIM"
        OutlinedTextField(
            value = insertUiEvent.nim,
            onValueChange = { onValueChange(insertUiEvent.copy(nim = it)) },
            label = { Text("NIM") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        // Input teks untuk "Jenis Kelamin"
        OutlinedTextField(
            value = insertUiEvent.jenisKelamin,
            onValueChange = { onValueChange(insertUiEvent.copy(jenisKelamin = it)) },
            label = { Text("Jenis Kelamin") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        // Input teks untuk "Alamat"
        OutlinedTextField(
            value = insertUiEvent.alamat,
            onValueChange = { onValueChange(insertUiEvent.copy(alamat = it)) },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        // Input teks untuk "Kelas"
        OutlinedTextField(
            value = insertUiEvent.kelas,
            onValueChange = { onValueChange(insertUiEvent.copy(kelas = it)) },
            label = { Text("Kelas") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        // Input teks untuk "Angkatan"
        OutlinedTextField(
            value = insertUiEvent.angkatan,
            onValueChange = { onValueChange(insertUiEvent.copy(angkatan = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Angkatan") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        // Menampilkan pesan "Isi Semua Data!" jika input aktif
        if (enabled) {
            Text(
                text = "Isi Semua Data!",
                modifier = Modifier.padding(12.dp)
            )
        }
        // Garis pemisah tebal
        Divider(
            thickness = 8.dp,
            modifier = Modifier.padding(12.dp)
        )
    }
}
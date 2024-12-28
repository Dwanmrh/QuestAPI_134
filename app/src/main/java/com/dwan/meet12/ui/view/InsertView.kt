package com.dwan.meet12.ui.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dwan.meet12.ui.navigation.DestinasiNavigasi
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
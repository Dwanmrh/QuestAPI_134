package com.dwan.meet12.ui.customwidget

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    title: String,
    canNavigateBack: Boolean, // Menentukan apakah ikon navigasi kembali akan ditampilkan.
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null, // Mendukung animasi saat toolbar di-scroll.
    navigateUp: () -> Unit = {}, // Fungsi yang dipanggil saat tombol navigasi kembali ditekan.
    onRefresh: () -> Unit = {} // Fungsi yang dipanggil saat tombol refresh ditekan.
) {
    CenterAlignedTopAppBar(
        title = {Text(title)},
        actions = {

            // Menambahkan ikon refresh di toolbar.
            Icon(imageVector = Icons.Default.Refresh, contentDescription = "", modifier = Modifier.clickable {
                onRefresh() // Memanggil fungsi refresh saat ikon ditekan.
            })
        },
        modifier = modifier,
        scrollBehavior = scrollBehavior, navigationIcon = { // Mengatur animasi scroll jika tersedia.
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        }
    )
}
package com.dwan.meet12.ui.view

import com.dwan.meet12.ui.navigation.DestinasiNavigasi

// Membuat objek `DestinasiEntry` yang mengimplementasikan interface `DestinasiNavigasi`
object DestinasiEntry : DestinasiNavigasi {

    // Mendefinisikan properti `route` yang mengacu pada string "item_entry"
    override val route = "item_entry"

    // Mendefinisikan properti `titleRes` yang mengacu pada string "Entry Mhs"
    override val titleRes = "Entry Mhs"
}

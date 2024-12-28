package com.dwan.meet12

import android.app.Application
import com.dwan.meet12.repository.AppContainer
import com.dwan.meet12.repository.MahasiswaContainer

class MahasiswaApplications:Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}
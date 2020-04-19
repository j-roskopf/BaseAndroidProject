package com.joetr.base

import android.app.Application
import com.joetr.base.di.BaseComponent
import com.joetr.base.di.DaggerBaseComponent
import com.joetr.data.di.RoomModule
import com.joetr.networking.di.NetworkModule

class BaseApplication : Application() {
    companion object {
        lateinit var baseComponent: BaseComponent
    }

    override fun onCreate() {
        super.onCreate()

        baseComponent = DaggerBaseComponent
            .builder()
            .networkModule(NetworkModule(this))
            .roomModule(RoomModule(this))
            .build()
    }
}

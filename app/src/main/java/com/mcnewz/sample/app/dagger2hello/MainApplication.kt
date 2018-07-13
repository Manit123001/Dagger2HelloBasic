package com.mcnewz.sample.app.dagger2hello

import android.app.Application
import com.mcnewz.sample.app.dagger2hello.di.AppComponent
import com.mcnewz.sample.app.dagger2hello.di.AppModule
import com.mcnewz.sample.app.dagger2hello.di.DaggerAppComponent

class MainApplication:Application(){
    companion object {
        lateinit var appComponent: AppComponent
    }
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

}
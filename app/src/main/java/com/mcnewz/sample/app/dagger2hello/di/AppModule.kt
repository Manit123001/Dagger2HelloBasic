package com.mcnewz.sample.app.dagger2hello.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.mcnewz.sample.app.dagger2hello.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(application: Application): SharedPreferences {
       return application.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)!!
    }
}
package com.mcnewz.sample.app.dagger2hello.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.mcnewz.sample.app.dagger2hello.MainApplication
import com.mcnewz.sample.app.dagger2hello.db.LocalDb
import com.mcnewz.sample.app.dagger2hello.db.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module (includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)!!
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): LocalDb {
        return Room
                .databaseBuilder(app, LocalDb::class.java, "hello-manit.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: LocalDb): UserDao {
        return db.userDao()
    }

}
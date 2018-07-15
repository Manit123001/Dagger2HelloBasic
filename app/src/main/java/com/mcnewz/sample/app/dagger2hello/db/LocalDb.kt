package com.mcnewz.sample.app.dagger2hello.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(
        entities = [User::class],
        version = 3,
        exportSchema = false
)
abstract class LocalDb : RoomDatabase() {

    abstract fun userDao(): UserDao

}

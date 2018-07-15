package com.mcnewz.sample.app.dagger2hello.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM user WHERE name = :login")
    fun findByLogin(login: String): LiveData<User>

    @Query("SELECT * FROM user")
    fun findAll(): LiveData<User>
}
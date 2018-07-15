package com.mcnewz.sample.app.dagger2hello.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user")
data class User(
        @PrimaryKey(autoGenerate = true)
        var id: String,
        @ColumnInfo(name = "name")
        var name: String,
        @ColumnInfo(name = "age")
        var age: Int) {
}
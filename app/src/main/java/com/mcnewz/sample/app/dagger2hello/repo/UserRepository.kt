package com.mcnewz.sample.app.dagger2hello.repo

import android.arch.lifecycle.LiveData
import com.mcnewz.sample.app.dagger2hello.db.LocalDb
import com.mcnewz.sample.app.dagger2hello.db.User
import com.mcnewz.sample.app.dagger2hello.db.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao, private val db: LocalDb) {


    fun addUser(user: User) {
//        db.runInTransaction {
//            userDao.insert(User("xxx", 11))
//        }
        userDao.insert(user)
    }

    fun selectUser(): LiveData<User> {
        return userDao.findAll()
    }
}
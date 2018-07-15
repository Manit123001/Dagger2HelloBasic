package com.mcnewz.sample.app.dagger2hello.ui

import android.arch.lifecycle.ViewModel
import com.mcnewz.sample.app.dagger2hello.db.LocalDb
import com.mcnewz.sample.app.dagger2hello.db.User
import com.mcnewz.sample.app.dagger2hello.repo.UserRepository
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    fun addData() {
        userRepository.addUser(User("manit", 19))
    }
}
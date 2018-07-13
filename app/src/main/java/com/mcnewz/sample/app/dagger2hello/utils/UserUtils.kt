package com.mcnewz.sample.app.dagger2hello.utils

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserUtils @Inject constructor() {

    fun hi(): String {
        return "Hello New"
    }
}
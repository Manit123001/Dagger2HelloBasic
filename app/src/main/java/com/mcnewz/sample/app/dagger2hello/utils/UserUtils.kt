package com.mcnewz.sample.app.dagger2hello.utils

import android.app.Application
import android.widget.Toast
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserUtils @Inject constructor(val application: Application) {

    fun hi(): String {
        return "Hello New"
    }

    fun yoyo(): String {
        return "YOYO MOM"
    }

    fun haha(): String {
        return "Hoooo Friends".also {
            Toast.makeText(application, "Hoooo Friends", Toast.LENGTH_LONG).show()
        }
    }
}
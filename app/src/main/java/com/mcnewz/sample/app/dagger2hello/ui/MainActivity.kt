package com.mcnewz.sample.app.dagger2hello.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.mcnewz.sample.app.dagger2hello.R
import com.mcnewz.sample.app.dagger2hello.di.Injectable
import com.mcnewz.sample.app.dagger2hello.utils.UserUtils
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, Injectable{

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>


    @Inject
    lateinit var user1: UserUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user1.haha()


        supportFragmentManager.beginTransaction()
                .add(R.id.container, UserFragment(), "User Fragment")
                .commit()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return androidInjector
    }
}

package com.mcnewz.sample.app.dagger2hello.di

import com.mcnewz.sample.app.dagger2hello.ui.UserFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    // The class that is injected
    fun inject(mainFragment: UserFragment)
}
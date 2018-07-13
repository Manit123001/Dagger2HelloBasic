package com.mcnewz.sample.app.dagger2hello.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mcnewz.sample.app.dagger2hello.R

class MainActivity : AppCompatActivity(){
//    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
//        return androidInjector
//    }
//
//    @Inject
//    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>
//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.container, UserFragment(), "User Fragment")
                .commit()
    }
}

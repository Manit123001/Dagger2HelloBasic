package com.mcnewz.sample.app.dagger2hello.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mcnewz.sample.app.dagger2hello.R
import com.mcnewz.sample.app.dagger2hello.di.Injectable
import com.mcnewz.sample.app.dagger2hello.utils.UserUtils
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class UserFragment : Fragment(), Injectable {
    @Inject
    lateinit var prefs: SharedPreferences

    lateinit var prefsEdit: SharedPreferences.Editor

    @Inject
    lateinit var user1: UserUtils

    // db
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private lateinit var background: Thread

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)

        prefsInit()
        dbInit()

    }

    override fun onStop() {
        super.onStop()
        background.interrupt()
    }

    private fun dbInit() {
        background = object : Thread() {
            override fun run() {
                userViewModel.addData()
            }
        }
        background.start()
    }

    private fun prefsInit() {
        prefsEdit = prefs.edit()
        prefsEdit.putString("name", "Manit")
        prefsEdit.putString("lastName", "Cholpinyo")
        prefsEdit.commit()
        val name = prefs.getString("name", "55")
        val lastName = prefs.getString("lastName", "66")
        toast("$name $lastName")

        tv_hello.text = user1.yoyo()
        toast(user1.hi() + user1.yoyo())
    }

    fun toast(s: String) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show()
    }

}

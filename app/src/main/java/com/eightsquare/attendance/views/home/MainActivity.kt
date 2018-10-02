package com.eightsquare.attendance.views.home

import android.os.Bundle
import com.eightsquare.attendance.R
import com.eightsquare.attendance.base.BaseActivity
import com.eightsquare.attendance.views.signin.LoginFragment


class MainActivity : BaseActivity() {
    override fun initView() {
        openFragmentNoHistory(LoginFragment())
    }

    override val layoutResourceId: Int
        get() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = this.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, LoginFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}

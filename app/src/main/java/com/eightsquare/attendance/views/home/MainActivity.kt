package com.eightsquare.attendance.views.home

import com.eightsquare.attendance.R
import com.eightsquare.attendance.base.BaseActivity
import com.eightsquare.attendance.views.signin.LoginFragment


class MainActivity : BaseActivity() {
    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override fun initView() {
        openFragmentNoHistory(LoginFragment())
    }


}

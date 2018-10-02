package com.eightsquare.attendance.views.signin

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.eightsquare.attendance.DatabaseActivity
import com.eightsquare.attendance.R
import com.eightsquare.attendance.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {
    override var latoutInt: Int
        get() = R.layout.fragment_login
        set(value) {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_login.setOnClickListener({
            val intent = Intent(context, DatabaseActivity::class.java)
            startActivity(intent)
        })

        button_register.setOnClickListener {
           openFragment(RegisterFragment())
        }
    }
}

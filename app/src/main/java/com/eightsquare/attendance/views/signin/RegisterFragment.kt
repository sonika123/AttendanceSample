package com.eightsquare.attendance.views.signin

import android.os.Bundle
import com.eightsquare.attendance.R
import com.eightsquare.attendance.base.BaseFragment
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : BaseFragment() {

    override val layoutId: Int get() = R.layout.fragment_register
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        var currentUser = mAuth?.currentUser
//        updateUI(currentUser)
    }

}


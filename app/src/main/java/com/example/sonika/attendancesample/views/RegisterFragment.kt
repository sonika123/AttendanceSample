package com.example.sonika.attendancesample.views

import android.os.Bundle
import com.example.sonika.attendancesample.R
import com.example.sonika.attendancesample.base.BaseFragment
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : BaseFragment() {

    private var mAuth: FirebaseAuth? = null
    override var latoutInt: Int
        get() = R.layout.fragment_register
        set(value) {}

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


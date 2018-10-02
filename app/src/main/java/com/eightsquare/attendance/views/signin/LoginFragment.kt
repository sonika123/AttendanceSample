package com.eightsquare.attendance.views.signin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import butterknife.BindView
import butterknife.OnClick
import com.eightsquare.attendance.DatabaseActivity
import com.eightsquare.attendance.R
import com.eightsquare.attendance.base.BaseFragment

class LoginFragment : BaseFragment() {

    override val layoutId: Int get() = R.layout.fragment_login

    @BindView(R.id.button_login)
    lateinit var mLoginButton: Button
    @BindView(R.id.button_register)
    lateinit var mRegisterButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * onClick listeners
     */
    @OnClick(R.id.button_login, R.id.button_register)
    fun viewItemClicked(view: View?) {
        when (view?.id) {
            R.id.button_login -> {
                val intent = Intent(context, DatabaseActivity::class.java)
                startActivity(intent)
            }
            R.id.button_register -> {
                openFragment(RegisterFragment())
            }
        }
    }
}

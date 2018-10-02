package com.eightsquare.attendance.views.signin

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.OnClick
import com.eightsquare.attendance.DatabaseActivity
import com.eightsquare.attendance.R
import com.eightsquare.attendance.base.BaseFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_login
    @BindView(R.id.button_login)
    lateinit var mLoginButton: Button
    @BindView(R.id.button_register)
    lateinit var mRegisterButton: Button
    @BindView(R.id.textView_email)
    lateinit var mEmail: TextInputEditText
    @BindView(R.id.textView_password)
    lateinit var mPassword: TextInputEditText


    var mAuth: FirebaseAuth? = null
    var mUser: FirebaseUser? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        mUser = mAuth!!.getCurrentUser()
    }

    @OnClick(R.id.button_login, R.id.button_register)
    fun viewItemClicked(view: View?) {
        when (view?.id) {
            R.id.button_login -> {
                loginActivity()
            }
            R.id.button_register -> {
                openFragment(RegisterFragment())
            }
        }
    }

    fun loginActivity() {
        val email = mEmail.text.toString().trim()
        val password = mPassword.text.toString().trim()

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "A Field is Empty", Toast.LENGTH_SHORT).show();
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "A Field is Empty", Toast.LENGTH_SHORT).show();
            return
        }

        mAuth?.signInWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(context as AppCompatActivity) { task ->
                    try {
                        //check if successful
                        if (task.isSuccessful) {
                            //User is successfully registered and logged in
                            mUser = mAuth?.getCurrentUser()

                            startActivity(Intent(context, DatabaseActivity::class.java))
                        } else {
                            Toast.makeText(context, "Couldn't login, try again",
                                    Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
    }
}
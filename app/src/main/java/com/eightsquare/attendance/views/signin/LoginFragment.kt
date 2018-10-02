package com.eightsquare.attendance.views.signin

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eightsquare.attendance.DatabaseActivity
import com.eightsquare.attendance.R
import com.eightsquare.attendance.base.BaseFragment
import com.example.sonika.attendancesample.Extentions.toastmessage

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {
    var mAuth: FirebaseAuth? = null
    var mUser: FirebaseUser? = null
    override var latoutInt: Int
        get() = R.layout.fragment_login
        set(value) {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        mUser = mAuth!!.getCurrentUser()

        button_login.setOnClickListener {
            //            val intent = Intent(context, DatabaseActivity::class.java)
//            startActivity(intent)
//            activity!!.toastmessage("Login clicked")
            loginActivity()
        }

        button_register.setOnClickListener {
            openFragment(RegisterFragment())
        }
    }

    private fun loginActivity() {
        val email = textView_email.text.toString().trim()
        val password = textView_password.text.toString().trim()

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

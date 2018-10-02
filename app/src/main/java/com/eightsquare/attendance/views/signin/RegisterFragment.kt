package com.eightsquare.attendance.views.signin

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import com.eightsquare.attendance.DatabaseActivity
import com.eightsquare.attendance.R
import com.eightsquare.attendance.base.BaseFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_register
    var mAuth: FirebaseAuth? = null

    @BindView(R.id.button_register_signup)
    lateinit var mSignupButton: Button
    @BindView(R.id.textView_email)
    lateinit var mEmail: TextInputEditText
    @BindView(R.id.textView_password)
    lateinit var mPassword: TextInputEditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance()

        mSignupButton.setOnClickListener({
            Toast.makeText(context, "register activity", Toast.LENGTH_SHORT).show()
            registerUser()
        })
    }


    fun registerUser() {
        val email = mEmail.text.toString()
        val password = mPassword.text.toString()

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "A Field is Empty", Toast.LENGTH_SHORT).show();
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "A Field is Empty", Toast.LENGTH_SHORT).show();
            return
        }
        mAuth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(context as AppCompatActivity) { task ->
                    try {
                        //check if successful
                        if (task.isSuccessful) {
                            //User is successfully registered and logged in
                            Toast.makeText(context, "registration successful",
                                    Toast.LENGTH_SHORT).show()
                            startActivity(Intent(context, DatabaseActivity::class.java))
                        } else {
                            Toast.makeText(context, "Couldn't register, try again",
                                    Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
    }
}
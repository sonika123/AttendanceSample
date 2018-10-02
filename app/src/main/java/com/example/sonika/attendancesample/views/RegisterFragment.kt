package com.example.sonika.attendancesample.views

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sonika.attendancesample.DatabaseActivity
import com.example.sonika.attendancesample.R
import com.example.sonika.attendancesample.base.BaseFragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : BaseFragment() {

    var mAuth: FirebaseAuth? = null

    override var latoutInt: Int
        get() = R.layout.fragment_register
        set(value) {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        button_register_signup.setOnClickListener({
            Toast.makeText(context, "register activity", Toast.LENGTH_SHORT).show()
            registerUser()
        })
    }

    fun registerUser() {
        val email = textView_email.text.toString()
        val password = textView_password.text.toString()

        if (TextUtils.isEmpty(email)){
            Toast.makeText(context, "A Field is Empty", Toast.LENGTH_SHORT).show();
            return
        }
        if (TextUtils.isEmpty(password)){
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
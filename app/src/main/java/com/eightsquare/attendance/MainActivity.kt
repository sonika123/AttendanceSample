package com.eightsquare.attendance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eightsquare.attendance.views.LoginFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager  = this.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, LoginFragment())
        fragmentTransaction.commit()
    }


}

package com.example.sonika.attendancesample.Extentions

import android.content.Context
import android.widget.Toast

fun Context.toastmessage(messageResId: String) {
    Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
}


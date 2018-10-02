package com.eightsquare.attendance

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_database.*


class DatabaseActivity : AppCompatActivity(), ValueEventListener {
    var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var reference = database.reference
    var textReference = reference.child("textContent")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)
        btn_save.setOnClickListener {
            submitText()
        }
    }

    override fun onCancelled(p0: DatabaseError) {
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        var stringBuilder = StringBuilder()
         for (datasnapshot in snapshot.children) {
             val content = datasnapshot.getValue(String::class.java)
                stringBuilder.append(content + "\n")
//             listDemo.add(User(name = content!!))
             Log.e("sonikamaharjan", content)


    }
        et_database.setText(stringBuilder.toString())

    }

    override fun onStart() {
        super.onStart()
        textReference.addValueEventListener(this)

    }

    private fun submitText() {
        val textInDatabase = edittext_value.text.toString()
        textReference.push().setValue(textInDatabase)
        edittext_value.setText(" ")
        et_database.setText(textInDatabase)
        Toast.makeText(this, "data is sent", Toast.LENGTH_SHORT).show()
    }
}

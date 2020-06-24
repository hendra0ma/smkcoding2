package com.corona.savelive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.corona.savelive.model.Modelinsert
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_chat_admin.*

class ChatAdmin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_admin)



        submit.setOnClickListener{insert()}
    }
    fun insert(){
        val firebase = FirebaseDatabase.getInstance().getReference("User")

        var id = firebase.push().key
        var insert = Modelinsert(id!!,edtNama.text.toString())
        firebase.child(id.toString()).setValue(insert).addOnCompleteListener{
            Toast.makeText(this,"berhasil",Toast.LENGTH_SHORT).show()
    }
    }



}



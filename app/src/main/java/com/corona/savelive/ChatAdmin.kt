package com.corona.savelive

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.corona.savelive.model.Modelinsert
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_chat_admin.*
import java.time.LocalDateTime

class ChatAdmin : AppCompatActivity() {
        private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_admin)
        submit.setOnClickListener{insert()}
    }
        fun insert(){
            val firebase = FirebaseDatabase.getInstance().getReference()
            auth = FirebaseAuth.getInstance()
            var id = firebase.push().key
            var uId = auth.getCurrentUser()?.getUid().toString()

            var insert = Modelinsert(id!!,edtNama.text.toString(),edtPesan.text.toString())
            firebase.child(uId).child("Pesan").push().setValue(insert).addOnCompleteListener{
                Toast.makeText(this,"berhasil",Toast.LENGTH_SHORT).show()
                Intent(this,MainActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
        }
    }



}



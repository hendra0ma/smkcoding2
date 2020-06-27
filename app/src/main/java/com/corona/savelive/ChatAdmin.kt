package com.corona.savelive

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.corona.savelive.R.layout.list_pesan
import com.corona.savelive.model.Modelinsert
import com.corona.savelive.viewModel.pesanViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_chat_admin.*
import java.time.LocalDateTime

class ChatAdmin : AppCompatActivity() {
    private val viewModel by viewModels<pesanViewModel>()
    private lateinit var auth : FirebaseAuth
    private val TAG = "myFirebase"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_admin)
        submit.setOnClickListener{insert()}
        viewModel.init(this)
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
    }

        fun insert(){
            val firebase = FirebaseDatabase.getInstance().getReference()
            auth = FirebaseAuth.getInstance()
            var id = firebase.push().key
            var uId = auth.getCurrentUser()?.getUid().toString()
            FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Log.w(TAG, "getInstanceId failed", task.exception)
                        return@OnCompleteListener
                    }

                    // Get new Instance ID token
                    val token = task.result?.token

                    // Log and toast

                    Log.d(TAG, edtNama.text.toString()+token)

                })

            var insert = Modelinsert(id!!,edtNama.text.toString(),edtPesan.text.toString())
            firebase.child(uId).child("Pesan").push().setValue(insert).addOnCompleteListener{
                Toast.makeText(this,"berhasil",Toast.LENGTH_SHORT).show()
                Intent(this,MainActivity::class.java).also {
                    viewModel.addData(insert)
                    startActivity(it)
                    finish()
                }
        }
    }



}



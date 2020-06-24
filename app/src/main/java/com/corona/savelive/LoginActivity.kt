package com.corona.savelive

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.ColorSpace
import android.os.Build.MODEL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() ,View.OnClickListener{
    private var auth:FirebaseAuth? = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        progress.visibility = View.GONE
        login.setOnClickListener ( this )
        if (auth!!.currentUser == null){
        }else{
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN){
            if (requestCode == Activity.RESULT_OK){
                Toast.makeText(this,"login berhasil",Toast.LENGTH_SHORT).show()
                startActivity(Intent(applicationContext,MainActivity::class.java))
            }else{
                Toast.makeText(this,"login dibatalkan",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onClick(v: View?) {
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(listOf(AuthUI.IdpConfig.GoogleBuilder().build()))
                .setIsSmartLockEnabled(false)
                .build(),RC_SIGN_IN
        )
        progress.visibility = View.VISIBLE
    }
    companion object{
        const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN =9001
    }

}
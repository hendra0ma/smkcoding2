package com.corona.savelive

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() ,View.OnClickListener{
    private var auth:FirebaseAuth? = null
    private var RC_SIGN_IN = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        progress.visibility = View.GONE
        login.setOnClickListener ( this )
        auth = FirebaseAuth.getInstance()
        if (auth!!.currentUser = null){
            Toast.makeText(this,"belum login",Toast.LENGTH_SHORT).show()
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

        )
    }
}
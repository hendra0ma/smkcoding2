package com.corona.savelive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btnRegister
import kotlinx.android.synthetic.main.activity_register.*


class LoginActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
            if(auth!!.currentUser == null){

            }else{
                Intent(this@LoginActivity,MainActivity::class.java).also { intent ->
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }


            btnLogin.setOnClickListener {

                val email = etEmail.text.toString().trim()
                val password = etPassword.text.toString().trim()
                when {
                    email.isEmpty() -> {
                        etEmail.error = "email harus di isi"
                        return@setOnClickListener
                    }
                    !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                        etEmail.error = "email tidak valid"
                        return@setOnClickListener
                    }
                    password.isEmpty() -> {
                        etPassword.error = "password harus di isi"
                        return@setOnClickListener
                    }
                }
                loginUser(email, password)

            }



        btnRegister.setOnClickListener {
            startActivity(
                Intent(this@LoginActivity,RegisterActivity::class.java)
            )

        }
    }

    private fun loginUser(emailit: String, passwordit: String) {
        auth.signInWithEmailAndPassword(emailit,passwordit).addOnCompleteListener(this){
            if(it.isSuccessful){
                Intent(this@LoginActivity,MainActivity::class.java).also {intent->
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }else{
                Toast.makeText(this@LoginActivity,it.exception?.message,Toast.LENGTH_SHORT).show()
            }
        }
    }



}
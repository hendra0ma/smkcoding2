package com.corona.savelive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()
        btnRegister.setOnClickListener {
            val email =  daftarEmail.text.toString().trim()
            val password = daftarPassword.text.toString().trim()
             when{
                email.isEmpty()->{
                    daftarEmail.error = "email harus di isi"
                    return@setOnClickListener
                }
                 !Patterns.EMAIL_ADDRESS.matcher(email).matches()->{
                     daftarEmail.error = "email tidak valid"
                     return@setOnClickListener
                 }
                password.isEmpty()->{
                    daftarPassword.error = "password harus di isi"
                    return@setOnClickListener
                }
            }
            registerEmail(email,password)

        }
    }

    private fun registerEmail(emailnya: String, passwordnya: String) {
            auth.createUserWithEmailAndPassword(emailnya,passwordnya)
                .addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Intent(this@RegisterActivity, MainActivity::class.java).also {
                            it.flags =  Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(it)
                        }
                    }else{
                        Toast.makeText(this@RegisterActivity,it.exception?.message,Toast.LENGTH_SHORT).show()
                    }
                }
    }


    override fun onStart() {
        super.onStart()
        if (auth.currentUser!= null){
            Intent(this@RegisterActivity,MainActivity::class.java).also {intent->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }else{
            Toast.makeText(this@RegisterActivity,"silhakan daftar",Toast.LENGTH_SHORT).show()
        }
    }
}
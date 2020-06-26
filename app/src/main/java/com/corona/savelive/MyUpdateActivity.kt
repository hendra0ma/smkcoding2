package com.corona.savelive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.corona.savelive.model.Modelinsert
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_my_update.*

class MyUpdateActivity : AppCompatActivity() {
    private var namaBaru: EditText? = null
    private var pesanBaru: EditText? = null
    lateinit var update: Button
    private var database: DatabaseReference? = null
    private var auth: FirebaseAuth? = null
    private var cekNama: String? = null
    private var cekPesan: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_update)
        namaBaru = findViewById(R.id.namaAndaku)
        pesanBaru = findViewById(R.id.editPesan)
        update = findViewById(R.id.btnSimpan)
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();
        val bundle = intent.extras
        getData()
        update.setOnClickListener {
            cekNama = namaBaru?.getText().toString()
            cekPesan = pesanBaru?.getText().toString()
            if (isEmpty(cekNama)||isEmpty(cekPesan)){
                Toast.makeText(this,"data tidak boleh kosong",Toast.LENGTH_SHORT).show()

            }else{
                val getKey = getIntent().getStringExtra("idKey").toString()
                val temanBaru = Modelinsert(getKey,cekNama!!,cekPesan!!)
                val getUserId : String = auth?.getCurrentUser()?.getUid().toString()
                database!!.child(getUserId).child("Pesan").child(getKey).removeValue()
                database!!.child(getUserId).child("Pesan").child(getKey).setValue(temanBaru).addOnCompleteListener {
                    finish()
                }
            }
        }

    }

    private fun getData() {
            val getNama : String = getIntent().getStringExtra("dataNama").toString()
            val getPesan : String = getIntent().getExtras()?.getString("dataPesan").toString()
            namaBaru?.setText(getNama)
            pesanBaru?.setText(getPesan)
        Toast.makeText(this,getNama,Toast.LENGTH_SHORT).show()

    }
}



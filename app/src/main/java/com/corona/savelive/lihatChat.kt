package com.corona.savelive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.corona.savelive.adapter.PesanAdapter
import com.corona.savelive.model.Modelinsert
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class lihatChat : AppCompatActivity() {
    lateinit var ref : DatabaseReference
    lateinit var auth : FirebaseAuth
    lateinit var listVIew : ListView
    lateinit var dataAdapter :MutableList<Modelinsert>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat_chat)
        dataAdapter = mutableListOf()
        auth = FirebaseAuth.getInstance()
        val uId = auth?.getCurrentUser()?.getUid().toString()
        ref = FirebaseDatabase.getInstance().getReference()
        ref.child(uId).child("Pesan").addValueEventListener(object :
        ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(this@lihatChat,"database error",Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(p0: DataSnapshot) {
                listVIew =findViewById(R.id.listPesan)
                for (dataSnap in p0.children){
                    val pesan = dataSnap.getValue(Modelinsert::class.java)
                    dataAdapter.add(pesan!!)
                }
                listVIew.adapter = PesanAdapter(this@lihatChat,R.layout.list_pesan,dataAdapter)
            }
        })
    }


}
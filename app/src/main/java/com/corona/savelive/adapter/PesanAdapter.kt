package com.corona.savelive.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.corona.savelive.MyUpdateActivity
import com.corona.savelive.R
import com.corona.savelive.model.Modelinsert
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_pesan.*


class PesanAdapter(private var context: Context,private var list :List<Modelinsert>):RecyclerView.Adapter<PesanAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(context).inflate(
        R.layout.list_pesan,parent,false))

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        lateinit var auth : FirebaseAuth
        lateinit var ref : DatabaseReference
        auth = FirebaseAuth.getInstance()
        ref = FirebaseDatabase.getInstance().getReference()
        holder.bindItem(list.get(position))
        holder.btnEdit.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("dataNama", list.get(position).nama)
            bundle.putString("dataPesan", list.get(position).pesan)
            bundle.putString("idKey",list.get(position).id)
            val intent = Intent(this.context, MyUpdateActivity::class.java)
            intent.putExtras(bundle)

            context.startActivity(intent)

        }

        holder.btnHapus.setOnClickListener {
             val uid = auth?.getCurrentUser()?.getUid().toString()
            ref.child(uid).child("Pesan").child(list.get(position)?.id.toString()).removeValue().addOnCompleteListener {
                Toast.makeText(this.context,"data terhapus",Toast.LENGTH_SHORT).show()
            }
        }
    }

    class ViewHolder(override val containerView : View):RecyclerView.ViewHolder(containerView),LayoutContainer{

           fun bindItem(item: Modelinsert){
            pesan.text = item.pesan
            namanyaSaya.text = item.nama

        }
    }
    interface dataListener{
        fun OnDeleteData(data : Modelinsert,position: Int)
    }

}
package com.corona.savelive.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.corona.savelive.R
import com.corona.savelive.model.Modelinsert
import kotlinx.android.synthetic.main.list_pesan.view.*

class PesanAdapter(val mctx : Context,val layoutres : Int,val list : List<Modelinsert>) : ArrayAdapter<Modelinsert>(mctx,layoutres,list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mctx)
        val view :View = layoutInflater.inflate(layoutres,null)
        val pesan = view.findViewById<TextView>(R.id.pesan)
        val nama = view.findViewById<TextView>(R.id.namanyaSaya)
        val PesanModel =list[position]
        pesan.text = PesanModel.pesan
        nama.text = PesanModel.nama
        return view
    }

}
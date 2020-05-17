package com.corona.savelive

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.data_provinsi_item.*

class CovidProvinsiAdapter(private val context :Context,private val items : List<DataprovinsiItem>,
                           private val listener:(DataprovinsiItem)->Unit):RecyclerView.Adapter<CovidProvinsiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(context,LayoutInflater.from(context)
        .inflate(R.layout.data_provinsi_item,parent,false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binItem(items.get(position),listener)
    }

    class ViewHolder(val context : Context,override val containerView: View):RecyclerView.ViewHolder(containerView),LayoutContainer{
        fun binItem(item:DataprovinsiItem,listener: (DataprovinsiItem) -> Unit){
            val atribut = item.attributes
            txtProvinsi.text = atribut.provinsi


            Positif.text = atribut.kasusPosi.toString()
            Sembuh.text = atribut.kasusSemb.toString()
            Meninggal.text = atribut.kasusMeni.toString()

                containerView.setOnClickListener { listener(item) }
        }
    }
}
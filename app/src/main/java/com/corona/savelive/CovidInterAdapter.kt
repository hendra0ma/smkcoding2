package com.corona.savelive

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.data_international_item.view.*


class CovidInterAdapter(private val context: Context,private val items : List<DataInterationalItem>,
                        private val listener : (DataInterationalItem)->Unit):RecyclerView.Adapter<CovidInterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder (context,LayoutInflater.from(context).inflate(R.layout.data_international_item,parent,false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position),listener)
    }
    class ViewHolder(val context: Context,override val containerView: View):RecyclerView.ViewHolder(containerView),LayoutContainer{
        fun bindItem(item:DataInterationalItem,listener: (DataInterationalItem) -> Unit){
         itemView.txtNegara.text = item.attributes.countryRegion
            itemView.Positif.text = item.attributes.confirmed.toString()
            itemView.Sembuh.text = item.attributes.recovered.toString()
            itemView.Meninggal.text = item.attributes.deaths.toString()
            containerView.setOnClickListener { listener(item) }


        }
    }
}
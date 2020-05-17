package com.corona.savelive

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.cegah_corona_item.*

class CegahCoronaAdapter (private  val context: Context,
                          private val items: ArrayList<CegahCorona>) :
                RecyclerView.Adapter<CegahCoronaAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder (LayoutInflater.from(context).inflate(R.layout.cegah_corona_item,parent,false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }
    class ViewHolder (override val containerView : View) : RecyclerView.ViewHolder(containerView),LayoutContainer{
    fun bindItem(item : CegahCorona){
        txtCegah.text = item.caracegah

    }


    }

}
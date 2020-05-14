package com.corona.savelive

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.data_corona.*
class CoronaAdapter(private val context: Context, private val items:
List<DataCoronaItem>, private val listener: (DataCoronaItem)-> Unit) :
    RecyclerView.Adapter<CoronaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(context, LayoutInflater.from(context).inflate(
            R.layout.data_corona,
            parent, false))
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }
    class ViewHolder(val context: Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: DataCoronaItem, listener: (DataCoronaItem) -> Unit) {



            containerView.setOnClickListener { listener(item) }
        }
    }
}
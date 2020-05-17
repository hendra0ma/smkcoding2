package com.corona.savelive

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.social_distance_item.*

class SocialDistanceAdapter (private val context: Context,private val items : ArrayList<DataClassSocial>):RecyclerView.Adapter<SocialDistanceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder (LayoutInflater.from(context).inflate(R.layout.social_distance_item,parent,false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }

    class   ViewHolder(override val containerView : View): RecyclerView.ViewHolder(containerView),LayoutContainer{

        fun bindItem(item : DataClassSocial){
            txtSocialDistance.text = item.social
        }
    }

    }

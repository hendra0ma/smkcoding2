package com.corona.savelive

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.corona.savelive.fragment.pesanFragment

class KotakAdapter (fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    private val menu = 4

    override fun createFragment(posisi: Int): Fragment {

       return when(posisi){
             0 -> CovidFragment()
           1-> ProvinsiFragment()
           2-> ReportVirusFragment()
           3->pesanFragment()
           else->pesanFragment()
        }
    }

    override fun getItemCount(): Int {
        return menu
    }
}
package com.corona.savelive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_covid.*

class MainActivity : AppCompatActivity() {


    val icon = arrayOf(R.drawable.ic_indonesia,R.drawable.ic_gaming,R.drawable.ic_world)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kotak.isUserInputEnabled =false
        val adapter = KotakAdapter(this)
        kotak.setAdapter(adapter)
        TabLayoutMediator(menuLayout,kotak, TabLayoutMediator.TabConfigurationStrategy {
                tab, position ->
            tab.icon = ResourcesCompat.getDrawable(resources,icon[position],null)
        }).attach()



    }




}

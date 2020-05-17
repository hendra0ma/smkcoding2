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


    val icon = arrayOf(R.drawable.ic_newspaper,R.drawable.ic_chat_black_24dp,R.drawable.report_virus)

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        cegahVIrus.setOnClickListener { startActivity(Intent(this@MainActivity,SplashScreen::class.java)) }
        kotak.isUserInputEnabled =false
        val adapter = KotakAdapter(this)
        kotak.setAdapter(adapter)
        TabLayoutMediator(menuLayout,kotak, TabLayoutMediator.TabConfigurationStrategy {
                tab, position ->
            tab.icon = ResourcesCompat.getDrawable(resources,icon[position],null)
        }).attach()



    }


}

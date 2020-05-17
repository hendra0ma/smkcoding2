package com.corona.savelive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_social_distance.*

class SocialDistance : AppCompatActivity() {

    lateinit var social : ArrayList<DataClassSocial>

    private fun dataSocial(){
        social = ArrayList()
        social.add(DataClassSocial("1. Jika berkumpul dengan keluarga sebisa mungkin berjarak minimal 1 meter"))
        social.add(DataClassSocial("2. Jika Berpergian selalu membawa masker dan berjaga jarak dengan orang lain"))
        social.add(DataClassSocial("3. Jika naik sepeda motor sebisa mungkin jangan bergoncengan dengan orang lain"))
        social.add(DataClassSocial("4. Jika Naik Mobil yang bermuatan maks 8 orang , sebisa mungkin hanya diisi setengahnya atau hanya 4 orang"))
    }
    private fun tampildata(){
        socialDistance.layoutManager = LinearLayoutManager(baseContext)
        socialDistance.adapter = SocialDistanceAdapter(baseContext!!,social)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_distance)
        dataSocial()
        tampildata()
    }
}

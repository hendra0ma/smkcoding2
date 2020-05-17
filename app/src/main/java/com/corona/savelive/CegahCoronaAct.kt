package com.corona.savelive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cegah_corona.*

class CegahCoronaAct : AppCompatActivity() {


    lateinit var cegahCorona : ArrayList<CegahCorona>

    private fun dataCegahCorona(){
        cegahCorona = ArrayList()

        cegahCorona.add(CegahCorona("1. Selalu cuci tangan pakai sabun"))
        cegahCorona.add(CegahCorona("2. Memakai masker jika berpergian"))
        cegahCorona.add(CegahCorona("3. Sebisa mungkin untuk selalu sosial ditancing "))
        cegahCorona.add(CegahCorona("4. Selalu membawa handsanitizer kemanapun pergi ,jika punya"))

    }
    private fun tampilData(){
        cegahCoronaItem.layoutManager = LinearLayoutManager(baseContext)
        cegahCoronaItem.adapter = CegahCoronaAdapter(baseContext!!,cegahCorona)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cegah_corona)
            dataCegahCorona()
            tampilData()
        btnDistance.setOnClickListener { startActivity(Intent(this,SocialDistance::class.java)) }
    }


}


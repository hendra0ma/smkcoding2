package com.corona.savelive

import CoronaAdapter
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.corona.savelive.data.CoronaService
import com.corona.savelive.data.apiRequest
import com.corona.savelive.data.httpClient
import com.corona.savelive.util.dissmisLoading
import com.corona.savelive.util.showLoading
import com.corona.savelive.util.tampilToast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.corona_item.*
import kotlinx.android.synthetic.main.fragment_covid.*
import kotlinx.android.synthetic.main.fragment_covid.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidFragment : Fragment() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_covid,container,false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiKawalCorona()
        view.btnLogout.setOnClickListener{
            logoutu()
        }
        btnCegah.setOnClickListener {
            val intent = Intent(this@CovidFragment.context,CegahCoronaAct::class.java)
            startActivity(intent)
        }

    }

    private fun logoutu() {
        val builder =AlertDialog.Builder(context)
        auth = FirebaseAuth.getInstance()
        val inflates : LayoutInflater = LayoutInflater.from(context)
        val view =inflates.inflate(R.layout.logout,null)
        builder.setView(view)
        builder.setPositiveButton("Yes"){p0,p1->
            auth.signOut()
            Intent(this.context,LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
        builder.setNegativeButton("No"){p0,p1->

        }

        builder.create().show()
    }


    private fun callApiKawalCorona() {
        showLoading(context!!, swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<CoronaService>(httpClient)
        val call = apiRequest.getProvinsi()
        call.enqueue(object : Callback<List<CoronaIndonesiaItem>>{
            override fun onFailure(call: Call<List<CoronaIndonesiaItem>>, t: Throwable) {
                dissmisLoading(swipeRefreshLayout)
            }
            override fun onResponse(call: Call<List<CoronaIndonesiaItem>>, response:
            Response<List<CoronaIndonesiaItem>>) {
                dissmisLoading(swipeRefreshLayout)
                when {
                    response.isSuccessful ->
                        when {
                            response.body()?.size != 0 ->
                                tampilCorona(response.body()!!)
                            else -> {
                                tampilToast(context!!, "Berhasil")
                            }
                        }
                    else -> {
                        tampilToast(context!!, "Gagal")
                    }
                }
            }
        })
    }
    private fun tampilCorona(positifCorona: List<CoronaIndonesiaItem>) {
        listCoronaData.layoutManager = LinearLayoutManager(context)
        listCoronaData.adapter = CoronaAdapter(context!!, positifCorona) {
            val positif_Corona = it
            tampilToast(context!!, positif_Corona.name)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}
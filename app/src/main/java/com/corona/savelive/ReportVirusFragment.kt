package com.corona.savelive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.corona.savelive.data.*
import com.corona.savelive.util.dissmisLoading
import com.corona.savelive.util.showLoading
import com.corona.savelive.util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_international.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ReportVirusFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    private fun callApiInter(){
        showLoading(context!!,swipeRefreshLayoutInter)

        val httpClient = httpClien()
        val apiRequest = apiRequestProvinsi<CoronaInternationalService>(httpClient)
        val call = apiRequest.getProvinsi()
        call.enqueue(object : Callback<List<DataInterationalItem>> {
            override fun onFailure(call: Call<List<DataInterationalItem>>, t: Throwable) {
                dissmisLoading(swipeRefreshLayoutInter)
            }


            override fun onResponse(
                call: Call<List<DataInterationalItem>>,
                response: Response<List<DataInterationalItem>>
            ) {
                dissmisLoading(swipeRefreshLayoutInter)
                when{
                    response.isSuccessful->when{
                        response.body()?.size != 0-> tampilDataInter(response.body()!!)
                        else-> tampilToast(context!!,"berhasil")
                    }else-> tampilToast(context!!,"Gagal")

                }
            }
        })
    }


    private fun tampilDataInter(dataCorona : List<DataInterationalItem>){
        dataInter.layoutManager = LinearLayoutManager(context)
        dataInter.adapter =  CovidInterAdapter(context!!,dataCorona){
            val data = it
            tampilToast(context!!,data.attributes.countryRegion)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_international,container,false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            callApiInter()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}
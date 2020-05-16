package com.corona.savelive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.corona.savelive.data.CoronaProvinsiService
import com.corona.savelive.data.apiRequestProvinsi
import com.corona.savelive.data.httpClien
import com.corona.savelive.util.dissmisLoading
import com.corona.savelive.util.showLoading
import com.corona.savelive.util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_covid.*
import kotlinx.android.synthetic.main.fragment_provinsi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinsiFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun callApiProvinsi(){
        showLoading(context!!,swipeRefreshLayout)

        val httpClient = httpClien()
        val apiRequest = apiRequestProvinsi<CoronaProvinsiService>(httpClient)
        val call = apiRequest.getProvinsi()
        call.enqueue(object :Callback<List<DataprovinsiItem>>{
            override fun onFailure(call: Call<List<DataprovinsiItem>>, t: Throwable) {
                dissmisLoading(swipeRefreshLayout)
            }

            override fun onResponse(
                call: Call<List<DataprovinsiItem>>,
                response: Response<List<DataprovinsiItem>>
            ) {
                dissmisLoading(swipeRefreshLayout)
                when{
                    response.isSuccessful->when{
                        response.body()?.size != 0-> tampilDataProvinsi(response.body()!!)
                        else-> tampilToast(context!!,"berhasil")
                    }else-> tampilToast(context!!,"Gagal")

                }
            }
        })
    }
    private fun tampilDataProvinsi(dataCorona : List<DataprovinsiItem>){
            updateCorona.layoutManager = LinearLayoutManager(context)
            updateCorona.adapter =  CovidProvinsiAdapter(context!!,dataCorona){
                val data = it
                tampilToast(context!!,data.attributes.provinsi)
            }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_provinsi,container,false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}


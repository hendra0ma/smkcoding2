package com.corona.savelive.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.corona.savelive.ChatAdmin
import com.corona.savelive.R
import com.corona.savelive.adapter.PesanAdapter
import com.corona.savelive.model.Modelinsert
import com.corona.savelive.viewModel.pesanFragmentViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.pesan_fragment.*

class pesanFragment : Fragment() ,PesanAdapter.dataListener{

    lateinit var ref: DatabaseReference
    private var auth: FirebaseAuth? = null

    var dataPesan: MutableList<Modelinsert> = ArrayList()
    private val viewModel by viewModels<pesanFragmentViewModel>()
    private var adapter : PesanAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, @Nullable
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pesan_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        getdata()
        viewModel.init(requireContext())
        viewModel.Allpesan.observe(viewLifecycleOwner, Observer { pesan->
            pesan?.let { adapter?.setData(it)}
        })
        btnFab.setOnClickListener {
            Intent(getActivity(), ChatAdmin::class.java).also {
                getActivity()?.startActivity(it)
            }
        }

    }
    private fun init(){
        listPesan.layoutManager = LinearLayoutManager(context)
        adapter = PesanAdapter(requireContext(),dataPesan)
        listPesan.adapter = adapter
        adapter?.listener=this
    }


    private fun getdata() {
        auth = FirebaseAuth.getInstance()
        ref = FirebaseDatabase.getInstance().getReference()
        val uId = auth?.getCurrentUser()?.getUid().toString()
        ref.child(uId).child("Pesan").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(context, "database Error", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(p0: DataSnapshot) {
                dataPesan = java.util.ArrayList<Modelinsert>()
                for (snap in p0.children) {
                    val pesan = snap.getValue(Modelinsert::class.java)
                    pesan?.id = (snap.key!!)
                    dataPesan.add(pesan!!)
                }
                viewModel.insertAll(dataPesan)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

    override fun OnDeleteData(data: Modelinsert, position: Int) {
        auth = FirebaseAuth.getInstance()
        val getUserID: String = auth?.getCurrentUser()?.getUid().toString()
        ref.child(getUserID)
            .child("Teman")
            .child(data?.id!!.toString())
            .removeValue()
            .addOnSuccessListener {
                Toast.makeText(context, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show()
                viewModel.delete(data)
            }
    }

}
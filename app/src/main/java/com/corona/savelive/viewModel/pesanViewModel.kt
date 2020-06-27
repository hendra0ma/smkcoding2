package com.corona.savelive.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.corona.savelive.db.PesanDatabase
import com.corona.savelive.model.Modelinsert
import com.corona.savelive.repo.PesanRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class pesanViewModel() :ViewModel(){
    lateinit var repository: PesanRepository
    fun init(context: Context){
        val pesanDao = PesanDatabase.getDatabase(context).PesanDAO()
        repository = PesanRepository(pesanDao)

    }
    fun addData(pesan : Modelinsert)= viewModelScope.launch(Dispatchers.IO){
        repository.insert(pesan)
    }


}







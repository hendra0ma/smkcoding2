package com.corona.savelive.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.corona.savelive.db.PesanDatabase
import com.corona.savelive.model.Modelinsert
import com.corona.savelive.repo.PesanRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class pesanFragmentViewModel():ViewModel() {
    lateinit var repository: PesanRepository
    lateinit var Allpesan : LiveData<List<Modelinsert>>
    fun init(context: Context){
        val pesanDao = PesanDatabase.getDatabase(context).PesanDAO()
        repository  = PesanRepository(pesanDao)
        Allpesan = repository.allPesan
    }
    fun delete(pesan : Modelinsert) = viewModelScope.launch(Dispatchers.IO){
            repository.delete(pesan)
    }
    fun insertAll(pesan : List<Modelinsert>) = viewModelScope.launch(Dispatchers.IO){
        repository.deleteAll()
        repository.insertAll(pesan)
    }

}


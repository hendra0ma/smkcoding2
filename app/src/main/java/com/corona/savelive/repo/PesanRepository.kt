package com.corona.savelive.repo

import androidx.lifecycle.LiveData
import com.corona.savelive.DAO.PesanDAO
import com.corona.savelive.model.Modelinsert

class PesanRepository(private val pesanDAO: PesanDAO) {
    val allPesan : LiveData<List<Modelinsert>> = pesanDAO.getAllPesan()
    suspend fun insert(pesan : Modelinsert){
        pesanDAO.insert(pesan)
    }
    suspend fun insertAll(pesan : List<Modelinsert>){
        pesanDAO.insertAll(pesan)
    }
    suspend fun deleteAll(){
        pesanDAO.deleteAll()
    }
    suspend fun update(pesan: Modelinsert){
            pesanDAO.update(pesan)
    }
    suspend fun delete(pesan : Modelinsert){
        pesanDAO.delete(pesan)
    }
}
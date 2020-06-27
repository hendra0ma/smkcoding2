package com.corona.savelive.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.corona.savelive.model.Modelinsert

@Dao
interface PesanDAO {
    @Query("Select * from Pesan")
    fun getAllPesan():LiveData<List<Modelinsert>>
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insert(myFriend: Modelinsert)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(myFriends: List<Modelinsert>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(myFriend: Modelinsert)

    @Delete()
    suspend fun delete(myFriend: Modelinsert)

    @Query("DELETE FROM Pesan")
    suspend fun deleteAll()

}
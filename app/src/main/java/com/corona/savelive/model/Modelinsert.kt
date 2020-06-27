package com.corona.savelive.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Pesan")
data class Modelinsert(
        @PrimaryKey var id: String,
        val nama: String,
        val pesan :String){
        constructor():this("","","")
}
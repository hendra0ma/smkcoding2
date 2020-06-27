package com.corona.savelive.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.corona.savelive.DAO.PesanDAO
import com.corona.savelive.model.Modelinsert

@Database(entities = arrayOf(Modelinsert::class), version = 1, exportSchema = false)
public abstract class  PesanDatabase : RoomDatabase(){
    abstract fun PesanDAO():PesanDAO
    companion object{
        @Volatile
        private var INSTANCE: PesanDatabase? = null

        fun getDatabase(context: Context): PesanDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PesanDatabase::class.java,
                    "Pesan_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

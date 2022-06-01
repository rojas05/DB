package sena.yamboro.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [usuario::class], version = 1)
abstract class BDprueva:RoomDatabase(){
   // abstract val userDao: Unit
    abstract fun usuarioDao():userDao

    companion object{
        var instancia : BDprueva?=null
        fun getInstancia(context: Context):BDprueva{
            if (instancia == null){
                instancia = Room.databaseBuilder(
                    context.applicationContext,
                    BDprueva::class.java,"database-name.db"
                ).build()
            }
            return instancia!!
        }
    }
}
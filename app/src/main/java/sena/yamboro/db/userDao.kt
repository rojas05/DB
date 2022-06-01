package sena.yamboro.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface userDao {
    @Query("SELECT * FROM usuario")
    suspend fun getAll(): List<usuario>
    @Insert
    suspend fun insertAll(vararg users: usuario)

    @Query("insert into usuario values(:id,:nombre,:apellido)")
    suspend fun actualizar (nombre:String,apellido:String,id:Int)
   // fun actualizar(usuario: usuario)

    /*  @Query("SELECT * FROM usuario WHERE uid IN (:userIds)")
      suspend fun loadAllByIds(userIds: IntArray): List<usuario>

      @Query("SELECT * FROM usuario WHERE first_name LIKE :first AND " +
              "last_name LIKE :last LIMIT 1")
      suspend fun findByName(first: String, last: String): usuario



     //@Query("update usuario set frist_name =:nombre, =:apellido where uid=:id")
      //suspend fun ac

      @Delete
      suspend fun delete(user: usuario)*/
}
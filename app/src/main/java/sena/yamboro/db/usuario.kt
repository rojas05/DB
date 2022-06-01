package sena.yamboro.db

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class usuario(
        @PrimaryKey(autoGenerate = true) val uid: Int?,
        @ColumnInfo(name = "nombre") val firstName: String?,
        @ColumnInfo(name = "apellido") val lastName: String?,
        )
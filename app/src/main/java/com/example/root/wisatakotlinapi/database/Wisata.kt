package com.example.root.wisatakotlinapi.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Wisata {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
    @ColumnInfo(name = "lokasi")
    var lokasi: String? = null
    @ColumnInfo(name = "nama_tempat")
    var namaTempat: String? = null
    @ColumnInfo(name = "deskripsi")
    var deskripsi: String? = null
    @ColumnInfo(name = "gambar")
    var gambar: String? = null
}
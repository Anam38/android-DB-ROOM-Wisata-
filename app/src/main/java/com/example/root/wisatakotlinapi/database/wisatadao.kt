package com.example.root.wisatakotlinapi.database

import android.arch.persistence.room.*

@Dao
interface wisatadao {
    @Query("SELECT * FROM wisata")
    fun getAll(): List<Wisata>

    @Query("SELECT * FROM wisata WHERE uid = :wisataIds")
    fun loadAllByIds(wisataIds: Int): Wisata

    @Insert
    fun insertAll(vararg wisata: Wisata)

    @Update
    fun update(vararg  wisata: Wisata)

    @Delete
    fun delete(wisata: Wisata)
}
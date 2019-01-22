package com.example.root.wisatakotlinapi.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

    @Database(entities = arrayOf(Wisata::class), version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun wisatadao():wisatadao
        companion object {
            fun getDatabase(context: Context): AppDatabase {

                val db = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "db.wisata"
                ).build()

                return db

            }
        }

    }
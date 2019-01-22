package com.example.root.wisatakotlinapi


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.root.wisatakotlinapi.adapter.MyItemRecyclerViewAdapter
import com.example.root.wisatakotlinapi.database.AppDatabase
import com.example.root.wisatakotlinapi.database.Wisata
import com.example.root.wisatakotlinapi.model.DataItem
import com.example.root.wisatakotlinapi.model.Resultgetdata
import com.example.root.wisatakotlinapi.retrofit.ConfigNetwork
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val config = ConfigNetwork().service
            config.getdata().enqueue(object : Callback<Resultgetdata> {
                override fun onFailure(call: Call<Resultgetdata>, t: Throwable) {

                }

                override fun onResponse(call: Call<Resultgetdata>, response: Response<Resultgetdata>) {

                    SaveData(response.body()!!.data)

                }

            })
    }

    private fun SaveData(data: List<DataItem?>?) {

        for (i in data?.indices!!){

            val item = Wisata()
            item.namaTempat = data.get(i)?.namaTempat
            item.deskripsi = data.get(i)?.deskripsi
            item.lokasi = data.get(i)?.lokasi
            item.gambar = data.get(i)?.gambar

            async(UI){
               bg {
                    AppDatabase.getDatabase(this@MainActivity).wisatadao().insertAll(item)
                }

            }
        }
        ambildata()

    }

    private fun ambildata() {

        async(UI){
            val data = bg {
                AppDatabase.getDatabase(this@MainActivity).wisatadao().getAll()
            }
            showData(data.await())
        }
    }

    private fun showData(data: List<Wisata>) {

        recyclearview.adapter = MyItemRecyclerViewAdapter(data)
        recyclearview.layoutManager = LinearLayoutManager(this@MainActivity)
    }


}

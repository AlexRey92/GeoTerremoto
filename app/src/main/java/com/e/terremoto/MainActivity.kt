package com.e.terremoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var Adapter:TerremotoAdapter
    private var listadoTerremotos = mutableListOf<Terremoto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        Adapter= TerremotoAdapter()
        recyclerView.adapter = Adapter

        getRetroFit()
        getTerremoto()
    }

    private fun getTerremoto() {
            CoroutineScope(Dispatchers.IO).launch {
                val call = getRetroFit().create(ApiService::class.java).getWeekList()
                val response = call.body()
                listadoTerremotos.clear()
                if (call.isSuccessful) {
                    listadoTerremotos =
                        (response?.features?.map { Earthquake -> Earthquake.toTerremoto() } ?: emptyList() )
                                as MutableList<Terremoto>
                    Adapter.submitList(listadoTerremotos)
                } else {
                    Adapter.submitList(listOf())
                }

            }

    }


    private fun getRetroFit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        const val BASE_URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/"
    }
}







/*
response?.apply {
                        listOfMeals = this.categories
                        adapter.submitList(listOfMeals)
 */
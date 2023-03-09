package com.e.terremoto

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(value = "significant_week.geojson")
    suspend fun getWeekList():Response<Features>
}
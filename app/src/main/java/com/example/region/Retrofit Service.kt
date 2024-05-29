package com.example.region

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("region/{region}?fields=name,subregion")
    suspend fun getCountriesByRegion(@Path("region") region: String): List<Country>
}
package com.example.region

import javax.inject.Inject

class CountryRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getCountriesByRegion(region: String): List<Country> {
        return try {
            apiService.getCountriesByRegion(region)
        } catch (e: Exception) {
            emptyList() // or throw a custom exception
        }
    }
}


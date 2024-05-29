package com.example.region

import com.squareup.moshi.Json

data class Country(
    @Json(name = "name") val name: CountryName,
    @Json(name = "subregion") val subregion: String
)

data class CountryName(
    @Json(name = "common") val common: String
)
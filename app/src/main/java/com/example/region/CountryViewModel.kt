package com.example.region

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(private val repository: CountryRepository) : ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val subregions = MutableLiveData<List<String>>()
    val selectedSubregionCountries = MutableLiveData<List<Country>>()

    fun fetchCountriesByRegion(region: String) {
        viewModelScope.launch {
            val response = repository.getCountriesByRegion(region)
            countries.value = response
            subregions.value = response.map { it.subregion }.distinct()
        }
    }

    fun fetchCountriesBySubregion(subregion: String) {
        selectedSubregionCountries.value = countries.value?.filter { it.subregion == subregion }
    }
}

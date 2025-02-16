package com.example.googlemaplinker.view

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlemaplinker.repository.*
import kotlinx.coroutines.launch

class LocationViewModel(): ViewModel() {
    private val _location = mutableStateOf<LocationData?>(null)

    val  location: State<LocationData?> = _location

    private val _address = mutableStateOf(listOf<GeocodingResult>())
    val address: State<List<GeocodingResult>> = _address
    private val apikey = "" // TODO: input APIKey

    fun updateLocation(newLocation: LocationData) {
        _location.value = newLocation
    }

    fun fetchAddress(latlng: String) {
        try {
            viewModelScope.launch {
                val result = RetrofitClient.create().getAddressFromCorrdinates(
                    latlng,
                    apikey
                )
                _address.value = result.result
            }
        } catch(e: Exception) {
            Log.d("res1", "${e.cause} ${e.message}")
        }
    }
}
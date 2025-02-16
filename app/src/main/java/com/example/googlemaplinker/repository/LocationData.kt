package com.example.googlemaplinker.repository

data class LocationData(
    val lattitude: Double,
    val longitude: Double
)

data class GeocodingResponse(
    val result: List<GeocodingResult>,
    val status: String
)

data class GeocodingResult(
    val formatted_address: String
)

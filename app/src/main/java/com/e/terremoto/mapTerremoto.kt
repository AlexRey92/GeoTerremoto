package com.e.terremoto

fun Earthquake.toTerremoto() = Terremoto(
    id, properties.place, properties.mag.toFloat(), geometry.longitude.toString()
)
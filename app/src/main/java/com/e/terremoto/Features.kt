package com.e.terremoto

data class Features (
val features:MutableList<Earthquake>
        )
data class Earthquake (
        val id:String,
        val type:String,
        val properties:Properties,
        val geometry:Geometry

                )

data class Properties(
        val mag:Double,
        val place:String,
        val time:Long,
)
data class Geometry (
        val type:String,
        val coordinates:MutableList<Double>
        )
{
        val longitude: Double
                get() = coordinates[0]
        val latitude: Double
                get() = coordinates[1]
}





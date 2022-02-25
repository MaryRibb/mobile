package com.example.secondone.data

data class CurrencyResponse (
    val success:Boolean,
    val timestamp:Long,
    val base:String,
    val data:String,
    val rates:Map<String,Double>
)
package com.example.secondone.data

import retrofit2.http.GET

interface CurrencyApi
{
    @GET("/api/latest?access_key=2a80b3f6217eb020c44a8be900033799")
    suspend fun getCurrencies():CurrencyResponse
}
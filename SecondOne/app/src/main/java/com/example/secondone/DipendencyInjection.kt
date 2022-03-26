package com.example.secondone

import com.example.secondone.data.CurrencyApi
import com.example.secondone.data.CurrencyRepository
import com.example.secondone.data.LocalDataSource
import com.example.secondone.data.RemoteDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DipendencyInjection {
    private val interceptor = HttpLoggingInterceptor().also {
        it.setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("http://data.fixer.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(CurrencyApi::class.java)

    private val remoteData = RemoteDataSource(service)
    private val localData = LocalDataSource()
    val repository = CurrencyRepository(localData, remoteData)
}
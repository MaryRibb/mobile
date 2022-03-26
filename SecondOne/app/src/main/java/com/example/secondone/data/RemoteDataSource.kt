package com.example.secondone.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource(val service: CurrencyApi) {

    suspend fun Source(): CurrencyResponse {

        val currencies = service.getCurrencies()
        return currencies

    }



//    private suspend fun doWork() {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
//        val retrofit = Retrofit.Builder()
//            .client(client)
//            .baseUrl("http://data.fixer.io/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val service = retrofit.create(CurrencyApi::class.java)
//        val currencies = service.getCurrencies()
//        Log.d("MY_TAG","$currencies")

    }




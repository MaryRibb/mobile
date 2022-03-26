package com.example.secondone.data

import com.example.secondone.MainActivity
//import kotlinx.android.synthetic.main.main_fragment.*


class CurrencyRepository(private val localDataSource: LocalDataSource,private  val remoteDataSource: RemoteDataSource) {

    suspend fun getCurrencies(): CurrencyResponse {
        return remoteDataSource.Source()
    }

}
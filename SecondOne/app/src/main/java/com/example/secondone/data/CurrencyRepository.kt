package com.example.secondone.data

import com.example.secondone.MainActivity
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.Job

class CurrencyRepository {
    suspend fun getRemoteCurrency() {
        return RemoteDataSource().main()
    }

}
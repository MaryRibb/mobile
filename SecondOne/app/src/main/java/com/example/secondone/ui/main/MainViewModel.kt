package com.example.secondone.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.secondone.data.CurrencyRepository
import com.example.secondone.data.CurrencyResponse
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel(private val repository: CurrencyRepository) : ViewModel() {
    val livedata = MutableLiveData<CurrencyResponse>()

    fun init()  = runBlocking{ // this: CoroutineScope
        launch { // launch a new coroutine and continue
            val currencies = repository.getCurrencies()
            livedata.postValue(currencies)
            Log.d("MY_TAG", "$livedata")
        }
    }
}
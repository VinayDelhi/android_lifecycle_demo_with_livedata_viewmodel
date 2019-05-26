package com.demo.lifecycle

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val liveData = MutableLiveData<String>()

    private val timer = object : CountDownTimer(60000,3000){
        override fun onFinish() {

        }

        override fun onTick(millisUntilFinished: Long) {

            liveData.postValue("$millisUntilFinished")
        }

    }

    fun start(){
        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}
package com.min.test1

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    val TAG = javaClass.simpleName
    var counter = MutableLiveData<Int>().apply {
        value=0
    }

    fun getcounter() : MutableLiveData<Int> {

        return counter
    }

    fun oncounter(){
        counter.value=4

    }
    fun onincrease(){
        counter.value=2
    }
    override fun onCleared() {
        super.onCleared()
        Log.e(TAG,"onCleared")
    }
}
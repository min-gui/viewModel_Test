package com.min.test1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainMainViewModel : ViewModel() {

    var fragmentBeing = MutableLiveData<Int>().apply { value=0 }

    fun getFragment() : MutableLiveData<Int> {
        fragmentBeing.value=1
        return fragmentBeing
    }
}
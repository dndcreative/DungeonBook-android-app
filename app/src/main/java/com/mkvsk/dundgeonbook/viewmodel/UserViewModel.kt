package com.mkvsk.dundgeonbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hewix"
    }
    val text: LiveData<String> = _text

    private val _healthPoints = MutableLiveData<Int>(15)
    val healthPoints: LiveData<Int> get() = _healthPoints

    fun setHealthPoints(value: Int) {
        _healthPoints.value = value
    }

}
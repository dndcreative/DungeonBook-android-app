package com.mkvsk.dundgeonbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel : ViewModel() {


    private val _healthPoints = MutableLiveData<Int>(15)
    val healthPoints: LiveData<Int> get() = _healthPoints

    fun setHealthPoints(value: Int) {
        _healthPoints.value = value
    }

}
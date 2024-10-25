package com.mkvsk.dundgeonbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _isNavViewVisible = MutableLiveData<Boolean>()
    val isNavViewVisible: LiveData<Boolean> get() = _isNavViewVisible

    fun setIsNavViewVisible(isVisible: Boolean) {
        _isNavViewVisible.value = isVisible
    }

    private val _isHealthStatsVisible = MutableLiveData<Boolean>()
    val isHealthStatsVisible: LiveData<Boolean> get() = _isHealthStatsVisible

    fun setIsHealthStatsVisible(isVisible: Boolean) {
        _isHealthStatsVisible.value = isVisible
    }

    private val _isCharacterInfoVisible = MutableLiveData<Boolean>()
    val isCharacterInfoVisible: LiveData<Boolean> get() = _isCharacterInfoVisible

    fun setIsCharacterInfoVisible(isVisible: Boolean) {
        _isCharacterInfoVisible.value = isVisible
    }

}

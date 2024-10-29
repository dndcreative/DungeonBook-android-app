package com.mkvsk.dundgeonbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mkvsk.dundgeonbook.core.Skill
import com.mkvsk.dundgeonbook.network.repository.SkillRepository
import kotlinx.coroutines.Dispatchers

class SkillViewModel : ViewModel() {

    private val _skill = MutableLiveData<Skill>()
    val skill: LiveData<Skill> get() = _skill

    fun setSkillValue(value: Skill) {
        _skill.value = value
    }

    private val _skillPoints = MutableLiveData<Int>()
    val skillPoints: LiveData<Int> get() = _skillPoints

    fun setSkillPoints(value: Int) {
        _skillPoints.value = value
    }

    private val _availablePoints = MutableLiveData<Int>(15)
    val availablePoints: LiveData<Int> get() = _availablePoints

    fun setAvailablePoints(value: Int) {
        _availablePoints.value = value
    }

    private val _skills = MutableLiveData<ArrayList<Skill>>()
    val skills: LiveData<ArrayList<Skill>> get() = _skills

    fun getSkillsValue(value: ArrayList<Skill>) {
        _skills.value!!.addAll(value)
    }
}
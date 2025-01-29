package com.mkvsk.dundgeonbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mkvsk.dundgeonbook.model.Skill

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
package com.mkvsk.dundgeonbook.ui.listeners

import com.mkvsk.dundgeonbook.model.Skill

interface OnPointChangeListener {
    fun onPointChangeListener(skill: Skill, availablePoints: Int)
}

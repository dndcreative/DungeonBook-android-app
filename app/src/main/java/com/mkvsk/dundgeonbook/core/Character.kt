package com.mkvsk.dundgeonbook.core

import java.io.Serializable

data class Character(
    private var id: Int = 0,
    private var name: String = "",
    private var health: Int = 0,
    private var stamina: Int = 0,
    private var mana: Int = 0,
    private var skill: Skill = Skill(),
    private var equipment: ArrayList<Equipment> = ArrayList(),
    private var abilities: ArrayList<Ability> = ArrayList()
) : Serializable


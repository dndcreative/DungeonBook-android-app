package com.mkvsk.dundgeonbook.network.requests

import com.mkvsk.dundgeonbook.core.Ability
import com.mkvsk.dundgeonbook.core.Equipment
import com.mkvsk.dundgeonbook.core.Skill

class UpdateCharacterRequest(
    private var id: Int = 0,
    private var name: String = "",
    private var health: Int = 0,
    private var stamina: Int = 0,
    private var mana: Int = 0,
    private var skill: Skill = Skill(),
    private var equipment: ArrayList<Equipment> = ArrayList(),
    private var abilities: ArrayList<Ability> = ArrayList()
)

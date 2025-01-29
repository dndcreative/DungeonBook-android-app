package com.mkvsk.dundgeonbook.model

import java.io.Serializable

data class Skill(
    private var id: Int = 0,
    private var strength: Int = 0,
    private var perception: Int = 0,
    private var endurance: Int = 0,
    private var charisma: Int = 0,
    private var intelligence: Int = 0,
    private var agility: Int = 0,
    private var luck: Int = 0
) : Serializable {
    fun getAllSkills(skill: Skill): Map<String, Int> {
        return mapOf(
            "Strength" to skill.strength,
            "Perception" to skill.perception,
            "Endurance" to skill.endurance,
            "Charisma" to skill.charisma,
            "Intelligence" to skill.intelligence,
            "Agility" to skill.agility,
            "Luck" to skill.luck
        )
    }
}
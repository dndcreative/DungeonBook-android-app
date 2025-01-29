package com.mkvsk.dundgeonbook.model

import java.io.Serializable

data class Ability(
    private var id: Int,
    private var title: String = "",
    private var subtitle: String = "",
    private var description: String = "",
    private var text: String = ""
) : Serializable
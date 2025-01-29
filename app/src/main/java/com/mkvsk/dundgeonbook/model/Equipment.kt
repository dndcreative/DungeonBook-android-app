package com.mkvsk.dundgeonbook.model

import java.io.Serializable

data class Equipment(
    private var id: Int = 0,
    private var propName: String = "",
    private var propDescription: String = "",
    private var propText: String = ""
) : Serializable
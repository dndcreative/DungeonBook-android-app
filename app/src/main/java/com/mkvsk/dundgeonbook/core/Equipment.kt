package com.mkvsk.dundgeonbook.core

import java.io.Serializable

data class Equipment(
    private var id: Int = 0,
    private var propName: String = "",
    private var propDescription: String = "",
    private var propText: String = ""
) : Serializable
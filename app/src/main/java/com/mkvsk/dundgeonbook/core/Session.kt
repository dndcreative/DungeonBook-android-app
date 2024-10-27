package com.mkvsk.dundgeonbook.core

import java.io.Serializable

data class Session(
    private var uuid: String = "",
    private var userUuid: String = "",
    private var name: String = "",
    private var password: String = "",
    private var maxUsers: Int = 0
) : Serializable
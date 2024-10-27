package com.mkvsk.dundgeonbook.network.requests

class UpdateEquipmentRequest(
    private var id: Int = 0,
    private var propName: String = "",
    private var propDescription: String = "",
    private var propText: String = ""
)
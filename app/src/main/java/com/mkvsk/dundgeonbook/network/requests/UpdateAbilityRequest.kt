package com.mkvsk.dundgeonbook.network.requests

class UpdateAbilityRequest(
    private var id: Int,
    private var title: String = "",
    private var subtitle: String = "",
    private var description: String = "",
    private var text: String = ""
)

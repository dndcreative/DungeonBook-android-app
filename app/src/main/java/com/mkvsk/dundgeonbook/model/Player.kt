package com.mkvsk.dundgeonbook.model

import java.io.Serializable

data class Player(
    private var session: Session? = null,
    private var uuid: String = "",
    private var name: String = "",
    private var password: String = "",
    private var playerType: PlayerType = PlayerType.PLAYER,
    private var selectedCharacter: Character = Character(),
    private var characters: ArrayList<Character> = ArrayList()
) : Serializable
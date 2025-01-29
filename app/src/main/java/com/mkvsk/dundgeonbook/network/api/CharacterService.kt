package com.mkvsk.dundgeonbook.network.api

import com.mkvsk.dundgeonbook.model.Character
import com.mkvsk.dundgeonbook.network.requests.UpdateCharacterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface CharacterService {
    @POST("/character/")
    suspend fun update(@Body requestBody: UpdateCharacterRequest?): Call<Character>

}

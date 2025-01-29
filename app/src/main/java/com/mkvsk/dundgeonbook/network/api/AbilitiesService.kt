package com.mkvsk.dundgeonbook.network.api

import com.mkvsk.dundgeonbook.model.Ability
import com.mkvsk.dundgeonbook.network.requests.UpdateAbilityRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface AbilitiesService {
    @POST("/ability/")
    suspend fun update(@Body requestBody: UpdateAbilityRequest?): Call<Ability>

}

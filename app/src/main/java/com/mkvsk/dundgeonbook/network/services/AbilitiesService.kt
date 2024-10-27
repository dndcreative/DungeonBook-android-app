package com.mkvsk.dundgeonbook.network.services

import com.mkvsk.dundgeonbook.core.Ability
import com.mkvsk.dundgeonbook.network.requests.UpdateAbilityRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface AbilitiesService {
    @POST("/ability/")
    suspend fun update(@Body requestBody: UpdateAbilityRequest?): Call<Ability>

}

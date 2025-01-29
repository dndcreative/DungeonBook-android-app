package com.mkvsk.dundgeonbook.network.api

import com.mkvsk.dundgeonbook.model.Skill
import com.mkvsk.dundgeonbook.network.requests.UpdateSkillRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface SkillService {
    @POST("/skill/")
    suspend fun update(@Body requestBody: UpdateSkillRequest?): Call<Skill>

}

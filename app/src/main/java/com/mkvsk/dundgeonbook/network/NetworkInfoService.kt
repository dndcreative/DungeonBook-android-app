package com.mkvsk.dundgeonbook.network

import com.mkvsk.dundgeonbook.core.Skill
import retrofit2.Response
import retrofit2.http.GET

interface NetworkInfoService {
    //    endpoints
//    @GET("/user")
//    suspend fun getUser(): Response<User>
//
//

    @GET("/skills")
    suspend fun getSkills(): Response<ArrayList<Skill>>


}
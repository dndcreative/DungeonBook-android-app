package com.mkvsk.dundgeonbook.network.services

import com.mkvsk.dundgeonbook.core.Player
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PlayerService {
    @GET("/player/all")
    suspend fun getAllUnits(@Query(value = "UserId") userId: String): Call<ArrayList<Player>>

}

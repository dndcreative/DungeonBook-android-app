package com.mkvsk.dundgeonbook.network.services

import com.mkvsk.dundgeonbook.core.Equipment
import com.mkvsk.dundgeonbook.network.requests.UpdateEquipmentRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface EquipmentService {
    @POST("/equipment/")
    suspend fun update(@Body requestBody: UpdateEquipmentRequest?): Call<Equipment>

}

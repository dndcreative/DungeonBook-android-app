package com.mkvsk.dundgeonbook.network

import com.mkvsk.dundgeonbook.network.api.AbilitiesService
import com.mkvsk.dundgeonbook.network.api.CharacterService
import com.mkvsk.dundgeonbook.network.api.EquipmentService
import com.mkvsk.dundgeonbook.network.api.PlayerService
import com.mkvsk.dundgeonbook.network.api.SkillService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val abilitiesService: AbilitiesService = getRetrofit().create(AbilitiesService::class.java)
    val characterService: CharacterService = getRetrofit().create(CharacterService::class.java)
    val equipmentService: EquipmentService = getRetrofit().create(EquipmentService::class.java)
    val playerService: PlayerService = getRetrofit().create(PlayerService::class.java)
    val skillService: SkillService = getRetrofit().create(SkillService::class.java)
}
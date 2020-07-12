package io.jgabriel.pagingv3

import io.jgabriel.pagingv3.model.CharacterResult
import retrofit2.http.GET
import retrofit2.http.Query

interface RickNMortyApi {
    @GET("api/character/")
    suspend fun getCharacters(@Query("page") page: Int): CharacterResult
}
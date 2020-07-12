package io.jgabriel.pagingv3.repository

import androidx.paging.PagingSource
import io.jgabriel.pagingv3.RickNMortyApi
import io.jgabriel.pagingv3.model.CharacterResult
import retrofit2.HttpException
import java.io.IOException

class MyPagingSource(
    private val api: RickNMortyApi
) : PagingSource<Int, CharacterResult.Character>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterResult.Character> {
        return try {
            val result = api.getCharacters(params.key ?: STARTING_PAGE_INDEX).characters ?: emptyList()
            LoadResult.Page(
                data = result,
                prevKey = params.key,
                nextKey = params.key?.plus(1) ?: STARTING_PAGE_INDEX.plus(1)
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}

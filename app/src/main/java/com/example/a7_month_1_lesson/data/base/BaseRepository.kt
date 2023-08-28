package com.example.a7_month_1_lesson.data.base

import com.example.a7_month_1_lesson.data.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    protected fun <T> makeRequest(coroutineRequest: suspend () -> T): Flow<Resource<T>> {
        return flow {
            emit(Resource.Loading())
            try {
                emit(Resource.Success(coroutineRequest()))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }
}
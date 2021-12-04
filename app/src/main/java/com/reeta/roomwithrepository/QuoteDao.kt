package com.reeta.roomwithrepository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface QuoteDao {

    @Query("select * from quote")
    fun getQuote():LiveData<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)
}
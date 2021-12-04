package com.reeta.roomwithrepository

import androidx.lifecycle.LiveData

class QuoteRepository(private val dao: QuoteDao) {

    fun getQuote():LiveData<List<Quote>>{
        return dao.getQuote()
    }

    suspend fun insert(quote: Quote){
        dao.insertQuote(quote)
    }
}
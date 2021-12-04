package com.reeta.roomwithrepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: QuoteRepository):ViewModel() {

    fun getQutoes():LiveData<List<Quote>>{
        return repository.getQuote()
    }

   suspend fun insertQuotes(quote: Quote){
        repository.insert(quote)
    }

}
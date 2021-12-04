package com.reeta.roomwithrepository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.reeta.roomwithrepository.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding :ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        val dao =QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository=QuoteRepository(dao)

        viewModel= ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        viewModel.getQutoes().observe(this,{
            binding.quotes=it.toString()
        })
        binding.btnAddQuote.setOnClickListener {
            val quote =Quote(0,"This is testing","testing")
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.insertQuotes(quote)
            }

        }
    }
}
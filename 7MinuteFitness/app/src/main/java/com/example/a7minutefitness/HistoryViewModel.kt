package com.example.a7minutefitness


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryViewModel(application: Application):AndroidViewModel(application) {

    val allHist: LiveData<List<HistoryEntity>>
    private val repository:HistoryRepository
    init{
        val dao=HistoryDatabase.getInstance(application).historyDao()
        repository=HistoryRepository(dao)
        allHist=repository.allHistory
    }

    fun insertDate(date:HistoryEntity)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(date)
    }
}
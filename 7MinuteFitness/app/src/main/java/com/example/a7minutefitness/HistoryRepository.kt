package com.example.a7minutefitness

import androidx.lifecycle.LiveData

class HistoryRepository(private val historyDao:HistoryDao) {
    val allHistory: LiveData<List<HistoryEntity>> =historyDao.fetchALlDates()

    suspend fun insert(historyEntity:HistoryEntity){
        historyDao.insert(historyEntity)
    }

}
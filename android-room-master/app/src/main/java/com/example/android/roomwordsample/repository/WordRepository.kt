package com.example.android.roomwordsample.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.android.roomwordsample.dao.WordDao
import com.example.android.roomwordsample.entity.Word

class WordRepository(private val wordDao: WordDao) {
    val allWord: LiveData<List<Word>> = wordDao.getAllWord()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}
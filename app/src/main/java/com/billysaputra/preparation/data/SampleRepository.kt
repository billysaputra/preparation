package com.billysaputra.preparation.data

import androidx.lifecycle.LiveData
import com.billysaputra.preparation.data.dao.SampleDao
import com.billysaputra.preparation.data.model.SampleDataClass

class SampleRepository(private val sampleDao: SampleDao) {
    val allHomeComponent: LiveData<List<SampleDataClass>> = sampleDao.getAllHomeComponent()

    suspend fun insert(home: SampleDataClass) {
        sampleDao.insert(home)
    }

    suspend fun deleteHomeComponentById(componentId: Int) {
        sampleDao.deleteHomeComponentById(componentId)
    }
}
package com.billysaputra.preparation.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.billysaputra.preparation.data.SampleDatabase
import com.billysaputra.preparation.data.SampleRepository
import com.billysaputra.preparation.data.model.SampleDataClass
import kotlinx.coroutines.launch

class SampleViewModel(application: Application) : AndroidViewModel(application) {
    private val sampleRepository: SampleRepository
    val allHomeComponent: LiveData<List<SampleDataClass>>

    init {
        val sampleDao = SampleDatabase.getDatabase(application).sampleDao()
        sampleRepository = SampleRepository(sampleDao)
        allHomeComponent = sampleRepository.allHomeComponent
    }

    fun insertHomeComponent(home: SampleDataClass) = viewModelScope.launch {
        sampleRepository.insert(home)
    }

    fun deleteHomeComponentById(homeComponentId: Int) = viewModelScope.launch {
        sampleRepository.deleteHomeComponentById(homeComponentId)
    }
}
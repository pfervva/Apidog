package com.example.dogapi.ui.modelview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapi.data.models.Dog
import com.example.dogapi.domain.usercase.GetDogsBreedUseCase
import com.example.dogapi.domain.usercase.GetDogsUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    var dogListLiveData = MutableLiveData<List<Dog>>()
    var progressBarLiveData = MutableLiveData<Boolean>()
    var search = MutableLiveData<String>()
    lateinit var useCaseList: GetDogsUseCase
    lateinit var useCaseBreedList: GetDogsBreedUseCase
    fun searchByBreed(breed: String) {
        search.value = breed
    }

    fun list() {
        viewModelScope.launch {
            progressBarLiveData.value = true
            delay(2000)
            useCaseList = GetDogsUseCase()
            val data: List<Dog> =
                useCaseList()
            data.let {
                dogListLiveData.value = it
                // dogListLiveData.postValue(it)
                progressBarLiveData.value = false
            }
        }
    }

    fun listForBreed(breed: String) {
        viewModelScope.launch {
            progressBarLiveData.value = true
            delay(2000)
            useCaseBreedList = GetDogsBreedUseCase(breed)
            val data: List<Dog> =
                useCaseBreedList()
            data.let {
                // dogListLiveData.postValue(it)
                dogListLiveData.value = it
                progressBarLiveData.value = false
            }
        }
    }
}
package com.example.dogapi.ui.modelview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapi.domain.model.Dog
import com.example.dogapi.domain.usercase.GetDogsBreedUseCase
import com.example.dogapi.domain.usercase.GetDogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class DogViewModel @Inject constructor(
    private var useCaseList: GetDogsUseCase,
    private val getDogsBreedUseCaseProvider: Provider<GetDogsBreedUseCase>
) : ViewModel() {
    var dogListLiveData = MutableLiveData<List<Dog>>()
    var progressBarLiveData = MutableLiveData<Boolean>()
    var search = MutableLiveData<String>()
    fun searchByBreed(breed: String) {
        search.value = breed
    }

    fun list() {
        viewModelScope.launch {
            progressBarLiveData.value = true
            delay(2000)
            val data: List<Dog> = useCaseList()
            data.let {
                // dogListLiveData.postValue(it)
                dogListLiveData.value = it
                progressBarLiveData.value = false
            }
        }
    }

    fun listForBreed(breed: String) {
        viewModelScope.launch {
            progressBarLiveData.value = true
            delay(2000)
            //useCaseBreedList = GetDogsBreedUseCase(breed)
            val useCaseBreedList = getDogsBreedUseCaseProvider.get()
            useCaseBreedList.setBreed(breed)
            val data: List<Dog> = useCaseBreedList()
            data.let {
                // dogListLiveData.postValue(it)
                dogListLiveData.value = it
                progressBarLiveData.value = false
            }
        }
    }
}
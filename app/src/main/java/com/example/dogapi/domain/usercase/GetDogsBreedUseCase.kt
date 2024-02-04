package com.example.dogapi.domain.usercase

import com.example.dogapi.data.models.DogRepository
import com.example.dogapi.domain.model.Dog
import javax.inject.Inject

class GetDogsBreedUseCase @Inject constructor(private val dogRepository: DogRepository) {
    private var breed: String = ""
    //private val dogRepository = DogRepository()

    fun setBreed(breed: String) {
        this.breed = breed
    }

    operator fun invoke(): List<Dog> {
        return dogRepository.getBreedDogs(breed)
    }
}

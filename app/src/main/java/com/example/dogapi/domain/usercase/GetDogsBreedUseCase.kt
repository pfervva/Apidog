package com.example.dogapi.domain.usercase

import com.example.dogapi.data.models.Dog
import com.example.dogapi.data.models.DogRepositoryDao

class GetDogsBreedUseCase(private val breed: String) {
    private val dogRepository = DogRepositoryDao()
    operator fun invoke(): List<Dog> {
        return dogRepository.getBreedDogs(breed)
    }
}

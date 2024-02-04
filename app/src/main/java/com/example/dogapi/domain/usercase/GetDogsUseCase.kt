package com.example.dogapi.domain.usercase

import com.example.dogapi.data.models.DogRepository
import com.example.dogapi.domain.model.Dog
import javax.inject.Inject

class GetDogsUseCase @Inject constructor(private val dogRepository: DogRepository) {
    operator fun invoke(): List<Dog> {
        return dogRepository.getDogs()
    }
}

package com.example.dogapi.domain.usercase

import com.example.dogapi.data.models.Dog
import com.example.dogapi.data.models.DogRepositoryDao

class GetDogsUseCase {
    private var dogRepository = DogRepositoryDao()
    operator fun invoke(): List<Dog> {
        return dogRepository.getDogs()
    }
}

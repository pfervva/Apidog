package com.example.dogapi.data.models

import com.example.dogapi.domain.model.Dog

interface DogRepositoryInterfaceDao {
    fun getDogs(): List<Dog>
    fun getBreedDogs(breed: String): List<Dog>
}
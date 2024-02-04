package com.example.dogapi.data.models

interface DogRepositoryInterfaceDao {
    fun getDogs(): List<Dog>
    fun getBreedDogs(breed: String): List<Dog>
}
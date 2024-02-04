package com.example.dogapi.data.service

import com.example.dogapi.data.datasource.Dogs

class DogService : DogServiceInterface {
    override fun getDogs(): List<Pair<String, String>> {
        return Dogs.dogs
    }

    override fun getBreedDogs(breed: String): List<Pair<String, String>> {
        val newDogs = Dogs.dogs.filter {
            it.first == breed
        }
        return newDogs
    }
}
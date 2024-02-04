package com.example.dogapi.data.service

import com.example.dogapi.data.datasource.Dogs
import javax.inject.Inject

class DogService @Inject constructor() : DogServiceInterface {
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
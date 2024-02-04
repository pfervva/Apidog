package com.example.dogapi.data.service

interface DogServiceInterface {
    fun getDogs(): List<Pair<String, String>>
    fun getBreedDogs(breed: String): List<Pair<String, String>>
}
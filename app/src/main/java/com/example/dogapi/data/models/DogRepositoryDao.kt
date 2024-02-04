package com.example.dogapi.data.models

import com.example.dogapi.data.service.DogService

class DogRepositoryDao : DogRepositoryInterfaceDao {
    private val service: DogService = DogService()
    override fun getDogs(): List<Dog> {
        val mutableDogs: MutableList<Dog> = mutableListOf()
        val dataSource = service.getDogs()
        dataSource.forEach { dog ->
            mutableDogs.add(Dog(dog.first, dog.second))
        }
        Repository.dogs = mutableDogs
        return Repository.dogs
    }

    override fun getBreedDogs(breed: String): List<Dog> {
        val mutableDogs: MutableList<Dog> = mutableListOf()
        val dataSource = service.getBreedDogs(breed)
        dataSource.forEach { dog ->
            mutableDogs.add(Dog(dog.first, dog.second))
        }
        Repository.dogs = mutableDogs
        return Repository.dogs
    }
}
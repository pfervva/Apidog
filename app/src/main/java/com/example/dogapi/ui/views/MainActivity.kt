package com.example.dogapi.ui.views

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogapi.databinding.ActivityMainBinding
import com.example.dogapi.domain.model.Dog
import com.example.dogapi.ui.adapter.DogAdapter
import com.example.dogapi.ui.modelview.DogViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private val dogViewModel: DogViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mySearch.setOnQueryTextListener(this)
        adapter = DogAdapter(mutableListOf())
        initRecyclerView()
        registerLiveData()
        loadData()
        //test()
    }

    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.myRecyclerView.adapter = adapter
    }

    private fun loadData() {
        dogViewModel.list()
    }

    private fun registerLiveData() {
        dogViewModel.dogListLiveData.observe(
            this
        ) { myList ->
            adapter.dogs = (myList as MutableList<Dog>?)!!
            binding.myRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
        dogViewModel.progressBarLiveData.observe(
            this
        ) { visible ->
            binding.progressBar.isVisible = visible
            Log.i("TAG-DOGS", "ProgressBar esta $visible")
        }
        dogViewModel.search.observe(
            this
        ) { bread ->
            dogViewModel.listForBreed(bread)
            hideKeyBoard()
        }
    }

    private fun hideKeyBoard() {
        val imn = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(binding.myRecyclerView.windowToken, 0)
    }

    private fun test() {
        //TestApi.testDogApi()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty())
            dogViewModel.searchByBreed(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText.isNullOrEmpty()) {
            dogViewModel.list()
            hideKeyBoard()
        }
        return true
    }
}
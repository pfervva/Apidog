package com.example.dogapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogapi.R
import com.example.dogapi.data.models.Dog

class DogAdapter(var dogs: MutableList<Dog> = mutableListOf()) :
    RecyclerView.Adapter<ViewHDog>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHDog {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.itemlist_cardview, parent, false)
        return ViewHDog(view)
    }

    override fun onBindViewHolder(holder: ViewHDog, position: Int) {
        holder.renderize(dogs[position], position)
    }

    override fun getItemCount(): Int {
        return dogs.size
    }
}
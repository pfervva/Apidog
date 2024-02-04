package com.example.dogapi.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogapi.domain.model.Dog
import com.example.dogapi.databinding.ItemlistCardviewBinding

class ViewHDog(
    view: View
) : RecyclerView.ViewHolder(view) {
    private var binding: ItemlistCardviewBinding

    init {
        binding = ItemlistCardviewBinding.bind(view)
    }

    fun renderize(dogs: Dog, position: Int) {
        binding.textTitle.text = dogs.name

        Glide
            .with(itemView.context)
            .load(dogs.image)
            .centerCrop()
            .into(binding.ivDog)
    }
}
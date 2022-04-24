package com.mramalldo.rvkotlinex.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mramalldo.rvkotlinex.R
import com.mramalldo.rvkotlinex.SuperHero
import com.mramalldo.rvkotlinex.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun render(superHeroModel: SuperHero, onClickListener:(SuperHero) -> Unit) {
        binding.tvSuperHeroName.text = superHeroModel.name
        binding.tvSuperHeroRealName.text = superHeroModel.realName
        binding.tvSuperHeroPublisher.text = superHeroModel.publisher
        Glide.with(binding.ivSuperHeroPhoto.context).load(superHeroModel.photo).into(binding.ivSuperHeroPhoto)

        itemView.setOnClickListener {
            onClickListener(superHeroModel)
        }
    }

}
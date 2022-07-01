package com.example.marvelapp.view


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.R
import com.example.marvelapp.databinding.LayoutRvItemBinding
import com.example.marvelapp.model.ResultModel


class MainAdapter(  private val openDetail: (ResultModel)-> Unit) : RecyclerView.Adapter<MainViewHolder>() {

    var characters = mutableListOf<ResultModel>()


    fun setList(characters: List<ResultModel>) {
        this.characters = characters.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MainViewHolder {

        return MainViewHolder(LayoutRvItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
//        val inflater = LayoutInflater.from(parent.context)
//
//        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
//        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val character = characters[position]
        holder.binding.characterName.text = character.name
        holder.binding.characterDescription.text = character.description
        val image=character.thumbnail.path+"."+character.thumbnail.extension
    //   Log.d("12312311TAG", "onBindViewHolder: "+character.thumbnail.getImage())
        val image1=image.replace("http","https")
        Glide.with(holder.itemView.context)
            .load(image1)
            .placeholder(R.drawable.img)
            .into(holder.binding.characterThumbnail)

        holder.binding.root.setOnClickListener{
            openDetail(character)
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }



}

class MainViewHolder(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {}
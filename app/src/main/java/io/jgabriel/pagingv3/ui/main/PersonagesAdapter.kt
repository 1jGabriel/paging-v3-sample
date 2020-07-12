package io.jgabriel.pagingv3.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.jgabriel.pagingv3.R
import io.jgabriel.pagingv3.extension.loadImage
import io.jgabriel.pagingv3.model.CharacterResult
import kotlinx.android.synthetic.main.character_item_list.view.*

class PersonagesAdapter() :
    PagingDataAdapter<CharacterResult.Character, PersonagesAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    class MyViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(character: CharacterResult.Character) {

            itemView.name.text = character.name
            itemView.imageView.loadImage(character.image)
            itemView.setOnClickListener {
                Toast.makeText(it.context, character.name + "Clicked", Toast.LENGTH_LONG).show()
            }
        }
    }
}

class DiffUtilCallBack : DiffUtil.ItemCallback<CharacterResult.Character>() {
    override fun areItemsTheSame(oldItem: CharacterResult.Character, newItem: CharacterResult.Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterResult.Character, newItem: CharacterResult.Character): Boolean {
        return oldItem == newItem
    }
}
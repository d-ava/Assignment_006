package com.example.assignment_006

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_006.databinding.RealEstateItemBinding
import com.example.assignment_006.model.RS
import com.example.assignment_006.model.RealEstate

class RealEstateAdapter : RecyclerView.Adapter<RealEstateAdapter.RSViewHolder>() {


   private var list: MutableList<RS.Content> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: MutableList<RS.Content>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RSViewHolder {
        return RSViewHolder(
            RealEstateItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RSViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = list.size


    inner class RSViewHolder(private val binding: RealEstateItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var charData: RS.Content

        fun onBind() {
            charData = list[adapterPosition]
            binding.tvPublishDate.text = charData.descriptionKA
            binding.tvtitleKA.text = charData.titleKA
            binding.tvDescription.text = charData.descriptionKA

        }

    }
}
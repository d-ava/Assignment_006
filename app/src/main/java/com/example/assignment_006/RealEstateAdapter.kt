package com.example.assignment_006

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment_006.databinding.RealEstateItemBinding
import com.example.assignment_006.extensions.glideImage
import com.example.assignment_006.model.RS
import com.squareup.picasso.Picasso
import java.lang.System.load

class RealEstateAdapter : RecyclerView.Adapter<RealEstateAdapter.RSViewHolder>() {


    private var list: MutableList<RS.Content> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<RS.Content>) {
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

        private lateinit var rsData: RS.Content

        fun onBind() {
            rsData = list[adapterPosition]
            binding.tvPublishDate.text = rsData.publishDate
            binding.tvtitleKA.text = rsData.titleKA
            binding.tvDescription.text = rsData.descriptionKA

            binding.IVimage.glideImage(rsData.cover) //using glide extension


            //without extension

          /*  Glide.with(itemView)
                .load(rsData.cover)
                .into(binding.IVimage) */


        }

    }
}
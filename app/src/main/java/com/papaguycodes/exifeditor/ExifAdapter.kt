package com.papaguycodes.exifeditor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.papaguycodes.exifeditor.databinding.ItemExifTagBinding
import com.papaguycodes.exifeditor.models.ExifData

class ExifAdapter(private val exifDataList: List<ExifData>) :
    RecyclerView.Adapter<ExifAdapter.ExifViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExifViewHolder {
        val binding = ItemExifTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExifViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExifViewHolder, position: Int) {
        holder.bind(exifDataList[position])
    }

    override fun getItemCount(): Int = exifDataList.size

    inner class ExifViewHolder(private val binding: ItemExifTagBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(exifData: ExifData) {
            binding.exifData = exifData
            binding.executePendingBindings()
        }
    }
}

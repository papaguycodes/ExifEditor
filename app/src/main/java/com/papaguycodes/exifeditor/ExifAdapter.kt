package com.papaguycodes.exifeditor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.papaguycodes.exifeditor.models.ExifData

class ExifAdapter(private val exifDataList: MutableList<ExifData>) :
    RecyclerView.Adapter<ExifAdapter.ExifViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExifViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exif_tag, parent, false)
        return ExifViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExifViewHolder, position: Int) {
        val exifData = exifDataList[position]
        holder.tagName.text = exifData.tagName
        holder.tagValue.setText(exifData.tagValue)

        holder.tagValue.addTextChangedListener {
            exifDataList[position].tagValue = it.toString()
        }
    }

    override fun getItemCount(): Int {
        return exifDataList.size
    }

    class ExifViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tagName: TextView = view.findViewById(R.id.tagName)
        val tagValue: EditText = view.findViewById(R.id.tagValue)
    }
}

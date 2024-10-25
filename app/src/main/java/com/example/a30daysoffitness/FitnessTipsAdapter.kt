package com.example.a30daysoffitness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FitnessTipsAdapter(private val tips: List<FitnessTip>) : RecyclerView.Adapter<FitnessTipsAdapter.TipViewHolder>() {

    // Inner class for the ViewHolder
    inner class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayTextView: TextView = view.findViewById(R.id.dayTextView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val tipImageView: ImageView = view.findViewById(R.id.tipImageView)
    }

    // Inflate the layout and create the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fitness_tip, parent, false)
        return TipViewHolder(view)
    }

    // Bind the data to the ViewHolder
    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        holder.dayTextView.text = "Day ${tip.day}"
        holder.titleTextView.text = tip.title
        holder.descriptionTextView.text = tip.description
        holder.tipImageView.setImageResource(tip.imageResId)
    }

    // Return the size of the dataset
    override fun getItemCount(): Int = tips.size
}

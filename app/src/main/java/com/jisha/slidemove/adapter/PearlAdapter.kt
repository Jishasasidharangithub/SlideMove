package com.jisha.slidemove.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jisha.slidemove.R

import com.jisha.slidemove.databinding.ItemPearlsBinding
import com.jisha.slidemove.modelclass.PearlItem

class PearlAdapter() : RecyclerView.Adapter<PearlAdapter.PearlItemViewHolder>() {

    private val pearlItems = mutableListOf<PearlItem>()

    inner class PearlItemViewHolder(val binding: ItemPearlsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PearlItemViewHolder {
        return PearlItemViewHolder(
            ItemPearlsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return pearlItems.size
    }

    fun updateList(list: List<PearlItem>) {
        pearlItems.clear()
        pearlItems.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PearlItemViewHolder, position: Int) {
        with(pearlItems[position]) {
            holder.binding.tvPearl.text = title
            if(isActive){
                holder.binding.ivInactiveDot.setImageResource(R.drawable.active_point)
            }
            else{
                holder.binding.ivInactiveDot.setImageResource(R.drawable.inactive_point)
            }
        }
    }

}
package com.jisha.slidemove.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jisha.slidemove.R
import com.jisha.slidemove.databinding.ItemGradientBinding
import com.jisha.slidemove.modelclass.GradientItem

class GradientAdapter : RecyclerView.Adapter<GradientAdapter.GradientItemViewHolder>() {

    private val gradientItem = mutableListOf<GradientItem>()

    inner class GradientItemViewHolder(val binding: ItemGradientBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradientItemViewHolder {
        return GradientItemViewHolder(
            ItemGradientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return gradientItem.size
    }

    fun updateList(list: List<GradientItem>) {
        gradientItem.clear()
        gradientItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GradientItemViewHolder, position: Int) {
        with(gradientItem[position]) {
            holder.binding.tvPearl.text = title


            val strokeWidth =
                holder.itemView.resources.getDimensionPixelSize(R.dimen._4sdp).toFloat()

            holder.binding.cvPearl.setGradientStrokeColors(
                startColor,
                middleColor,
                endColor,
                strokeWidth,
                90f
            )

            if (isActive) {
                holder.binding.ivSelector.visibility = ViewGroup.VISIBLE
                holder.binding.tvYouAreHere.visibility = ViewGroup.VISIBLE
            } else {
                holder.binding.ivSelector.visibility = ViewGroup.GONE
                holder.binding.tvYouAreHere.visibility = ViewGroup.GONE
            }
        }
    }

}
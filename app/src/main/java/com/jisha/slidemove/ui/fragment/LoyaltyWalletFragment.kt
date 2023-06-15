package com.jisha.slidemove.ui.fragment

import android.graphics.Color
import android.graphics.Outline
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jisha.slidemove.R
import com.jisha.slidemove.adapter.GradientAdapter
import com.jisha.slidemove.databinding.FragmentLoyaltyWalletBinding
import com.jisha.slidemove.modelclass.GradientItem


class LoyaltyWalletFragment : Fragment() {
    private var binding: FragmentLoyaltyWalletBinding? = null
    private val gradientAdapter: GradientAdapter by lazy { GradientAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoyaltyWalletBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun setCrownsBgGradient(startColor: String, middleColor: String, endColor: String) {
        try {
            val gradientDrawable = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(
                    Color.parseColor(startColor),
                    Color.parseColor(middleColor),
                    Color.parseColor(endColor)
                )
            )
            binding?.cslCrowns?.apply {
                background = gradientDrawable
                outlineProvider = object : ViewOutlineProvider() {
                    override fun getOutline(view: View, outline: Outline) {
                        val cornerRadius = resources.getDimension(R.dimen._5sdp) // 5dp
                        outline.setRoundRect(0, 0, view.width, view.height, cornerRadius)
                    }
                }
                clipToOutline = true
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    private fun init(){
        binding?.recyclerView?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = gradientAdapter
            gradientData()
        }
    }
    private fun gradientData() {
        setCrownsBgGradient("#804A00", "#EBA25B", "#804A00")

        val pearlItem = listOf(
            GradientItem(
                "Bronze", true, "#804A00", "#EBA25B", "#804A00"
            ), GradientItem(
                "Pearl", false, "#643300", "#9B5F23", "#491D00"
            ), GradientItem(
                "Silver", false, "#DCD6CA", "#F8F4EC", "#EBE0C6"
            ), GradientItem(
                "Gold", false, "#CFBF98", "#FFF8EB", "#CFBE94"
            )
        )
        gradientAdapter.updateList(pearlItem)
    }

}
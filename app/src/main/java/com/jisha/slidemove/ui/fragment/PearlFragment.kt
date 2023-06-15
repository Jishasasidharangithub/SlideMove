package com.jisha.slidemove.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jisha.slidemove.adapter.PearlAdapter
import com.jisha.slidemove.databinding.FragmentPearlBinding
import com.jisha.slidemove.modelclass.PearlItem

class PearlFragment : Fragment() {
    private var binding: FragmentPearlBinding? = null
    private val pearlAdapter: PearlAdapter by lazy { PearlAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPearlBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initView()
    }
    private fun init() {
        binding?.loyalityToolbar?.tvToolbarTitle?.text = "Loyalty Wallet"
    }

    private fun initView() {
        binding?.recyclerView?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = pearlAdapter
            pearlData()
        }
    }

    private fun pearlData() {
        Log.d("MainActivity", "pearlData: ")
        val pearlItem = listOf(
            PearlItem(
                "Bronze",false
            ), PearlItem(
                "Pearl",true
            ), PearlItem(
                "Silver",false
            ), PearlItem(
                "Gold",false
            )
        )
        pearlAdapter.updateList(pearlItem)
    }
}
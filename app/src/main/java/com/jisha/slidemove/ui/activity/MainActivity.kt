package com.jisha.slidemove.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.jisha.slidemove.R
import com.jisha.slidemove.adapter.PearlAdapter
import com.jisha.slidemove.databinding.ActivityMainBinding
import com.jisha.slidemove.modelclass.PearlItem

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val pearlAdapter: PearlAdapter by lazy { PearlAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initView()
    }
    private fun init() {
        binding?.loyalityToolbar?.tvToolbarTitle?.text = "Loyalty Wallet"
    }

    private fun initView() {
        binding?.recyclerView?.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = pearlAdapter
            pearlData()
        }
    }

    private fun pearlData() {
        Log.d("MainActivity", "pearlData: ")
        val pearlItem = listOf(
            PearlItem(
                "Pearl 1",false
            ), PearlItem(
                "Pearl 2",true
            ), PearlItem(
                "Pearl 3",false
            )
        )
        pearlAdapter.updateList(pearlItem)
    }
}
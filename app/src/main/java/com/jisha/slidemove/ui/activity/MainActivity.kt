package com.jisha.slidemove.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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

    }

}
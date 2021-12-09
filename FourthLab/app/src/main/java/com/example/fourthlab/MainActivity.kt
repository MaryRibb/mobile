package com.example.fourthlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fourthlab.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HumanAdapter
    override fun onDestroy() {
        super.onDestroy()
        HumanHolder.removeListener(humanListener)
    }
    private val humanListener: HumansListener = {
        adapter.humans = it
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = HumanAdapter(object : IHumanClickListener {
            override fun showHumanFio(name: String) {
                Snackbar.make(binding.root, "Нажата карточка: ${name}", 500).show()
            }
            override fun showLikeHumanFio(name: String) {
                Snackbar.make(binding.root, "Нажат лайк: ${name}", 500).show()
            }
        })
        val layoutManager = LinearLayoutManager(this)
        binding.recycleview.layoutManager = layoutManager
        binding.recycleview.adapter = adapter
        HumanHolder.addListener(humanListener)
    }
}
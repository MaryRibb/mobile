package com.example.dis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.dis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragments, Filter.newInstance())
                .commitNow()
        }
        return true

    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragments, items_history.newInstance())
                .commitNow()
        }
        binding.button2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragments, items_main.newInstance())
                .commitNow()
        }
        binding.button3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragments, Fragment_grafic.newInstance())
                .commitNow()
        }
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragments, items_main.newInstance())
                .commitNow()
        }

    }
}

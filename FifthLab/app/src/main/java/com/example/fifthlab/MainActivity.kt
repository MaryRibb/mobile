package com.example.fifthlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fifthlab.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

interface ActivityCallback {
    fun getNewHuman(human: Human)
}

class MainActivity : AppCompatActivity(), ActivityCallback {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HumanAdapter
    private var fragment: AsyncFragment? = null
    override fun getNewHuman(human: Human) {
        adapter.addNewHuman(human)
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
        val supportFragmentManager = supportFragmentManager
        val prevFragment = supportFragmentManager.findFragmentByTag(AsyncFragment.Tag)
        if (prevFragment == null) {
            fragment = AsyncFragment()
            supportFragmentManager
                .beginTransaction()
                .add(fragment!!, AsyncFragment.Tag)
                .commit()
        } else {
            fragment = prevFragment as AsyncFragment
            adapter.getPrevHumans(fragment!!.humans)
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager = LinearLayoutManager(this)
        binding.recycleview.layoutManager = layoutManager
        binding.recycleview.adapter = adapter


    }


}
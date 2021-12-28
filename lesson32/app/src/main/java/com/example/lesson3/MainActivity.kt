package com.example.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.lesson3.databinding.ActivityMainBinding

interface ActivityCollback{
    fun showNextFragment(x: Int)
    fun showBackFragment(x: Int)
    fun Exit()
}
class MainActivity : AppCompatActivity(), ActivityCollback{
    private lateinit var binding: ActivityMainBinding
    private var buttonList: MutableList<Button> = mutableListOf()
    private var fragmentList: List<Fragment> = listOf(Fragment1(), Fragment2(), Fragment3(), Fragment4())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        buttonList.add(0, binding.button1)
        buttonList.add(1, binding.button2)
        buttonList.add(2, binding.button3)
        buttonList.add(3, binding.button4)

        setClickListenerForButtons()
    }

    private fun setClickListenerForButtons(){
        buttonList[0].setOnClickListener{
            supportFragmentManager
                .beginTransaction().replace(R.id.fragments, fragmentList[0]).commit()
            buttonsManager(0)
        }
        buttonList[1].setOnClickListener{
            supportFragmentManager
                .beginTransaction().replace(R.id.fragments, fragmentList[1]).commit()
            buttonsManager(1)
        }
        buttonList[2].setOnClickListener{
            supportFragmentManager
                .beginTransaction().replace(R.id.fragments, fragmentList[2]).commit()
            buttonsManager(2)
        }
        buttonList[3].setOnClickListener{
            supportFragmentManager
                .beginTransaction().replace(R.id.fragments, fragmentList[3]).commit()
            buttonsManager(3)
        }

        supportFragmentManager
            .beginTransaction().replace(R.id.fragments, fragmentList[0]).commit()
        buttonsManager(0)
    }

    fun but(x: Int){
        for (i in fragmentList.indices){
            if ( i == x ) buttonList[i].setEnabled(true)
        }
    }

    fun butdestroy(x: Int){
        for (i in fragmentList.indices){
            if ( i == x ) buttonList[i].setEnabled(false)
        }
    }

    override fun showNextFragment(x: Int){
        supportFragmentManager.beginTransaction().replace(R.id.fragments, fragmentList[x]).commit()
        but(x)

    }

    override fun showBackFragment(x: Int) {
        supportFragmentManager.beginTransaction().replace(R.id.fragments, fragmentList[x - 2]).commit()
        butdestroy(x-1)
    }
    private fun buttonsManager(n: Int) {
        for (i in 0 until buttonList.count())
            buttonList[i].isEnabled = i <= n
    }

    override fun Exit() {
        finishAffinity()
        System.exit(0);
    }

}
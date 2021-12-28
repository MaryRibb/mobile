package com.example.lesson3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson3.databinding.ActivityMainBinding
import com.example.lesson3.databinding.Fragment2Binding
import com.example.lesson3.databinding.Fragment1Binding


class Fragment2 : Fragment(){
    private lateinit var binding: Fragment2Binding
    private var x :Int = 2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(layoutInflater)

        nextButtonClick()
        backButtonClick()
        return binding.root
    }

    private fun nextButtonClick(){
        binding.next.setOnClickListener{
            val activityCollback = requireActivity() as ActivityCollback
            Calculator.num2 = binding.editText1.text.toString().toDouble()
            activityCollback.showNextFragment(x)
        }
    }

    private fun backButtonClick(){
        binding.back.setOnClickListener {
            val activityCollback = requireActivity() as ActivityCollback
            activityCollback.showBackFragment(x)
        }
    }
}
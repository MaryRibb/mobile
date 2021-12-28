package com.example.lesson3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson3.databinding.Fragment3Binding
import com.example.lesson3.databinding.Fragment1Binding
import com.example.lesson3.databinding.Fragment2Binding


class Fragment3 : Fragment(){
    private lateinit var binding: Fragment3Binding
    private var x :Int = 3

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(layoutInflater)

        nextButtonClick()
        backButtonClick()
        setOnClickListeners()
        return binding.root
    }

    fun setOnClickListeners(){
        binding.minus.setOnClickListener{
            setOperation(binding.minus.text.toString())
        }
        binding.plus.setOnClickListener{
            setOperation(binding.plus.text.toString())
        }
        binding.multipy.setOnClickListener{
            setOperation(binding.multipy.text.toString())
        }
        binding.divide.setOnClickListener{
            setOperation(binding.divide.text.toString())
        }
    }
    fun setOperation(operation: String){
        Calculator.operation = operation
    }

    private fun nextButtonClick(){
        binding.next.setOnClickListener{
            val activityCollback = requireActivity() as ActivityCollback
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
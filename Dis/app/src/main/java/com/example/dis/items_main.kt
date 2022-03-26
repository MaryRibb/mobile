package com.example.dis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.dis.databinding.ActivityMainBinding
import com.example.dis.databinding.FragmentItemsMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [items_main.newInstance] factory method to
 * create an instance of this fragment.
 */
class items_main : Fragment() {

    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }

    lateinit var binding: FragmentItemsMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemsMainBinding.inflate(layoutInflater,container,false
        )
        binding.button4.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragments,fragment_exchange(),fragment_exchange::class.java.simpleName)
                    .addToBackStack(null).commit()

            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment items_main.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            items_main()
    }
}
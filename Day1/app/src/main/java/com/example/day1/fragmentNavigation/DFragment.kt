package com.example.day1.fragmentNavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.day1.R
import com.example.day1.databinding.FragmentDBinding


class DFragment : Fragment() {

    private var _binding: FragmentDBinding? = null
    private val binding get() = _binding!!


    val onPresBackEvent = {
        // Handle back press event
        // Return true if the event is consumed, false otherwise

        false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString("name") ?: "no name"

        binding.mainText.text = name

        binding.backButton.setOnClickListener {

            findNavController().navigateUp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
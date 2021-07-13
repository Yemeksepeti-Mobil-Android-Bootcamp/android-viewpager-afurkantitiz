package com.example.androidviewpager.fragments.onboarding_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.androidviewpager.R
import com.example.androidviewpager.databinding.FragmentSecondOnboardingBinding

class SecondOnboardingFragment : Fragment() {
    private var _binding: FragmentSecondOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root

        init()

        return view
    }

    private fun init() {
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.button.setOnClickListener {
            viewPager?.currentItem = 2
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
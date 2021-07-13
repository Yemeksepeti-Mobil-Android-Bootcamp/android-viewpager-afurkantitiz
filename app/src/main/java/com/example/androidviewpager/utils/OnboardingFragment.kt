package com.example.androidviewpager.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidviewpager.R
import com.example.androidviewpager.databinding.FragmentOnboardingBinding
import com.example.onboarding.utils.animation.VerticalFlipTransformer

class OnboardingFragment : Fragment() {
    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root

        initViewPager()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViewPager() {
        //In this function we take an object from the adapter we created and set it to the viewpager.
        val adapter = OnboardingAdapter(requireActivity())
        //We set the class we created to add animation to the Viewpager
        binding.viewPager.setPageTransformer(VerticalFlipTransformer())
        binding.viewPager.adapter = adapter
        binding.dotsIndicator.setViewPager2(binding.viewPager)
    }
}
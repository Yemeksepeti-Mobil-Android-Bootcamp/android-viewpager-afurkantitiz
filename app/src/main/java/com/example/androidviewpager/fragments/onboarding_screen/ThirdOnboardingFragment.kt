package com.example.androidviewpager.fragments.onboarding_screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidviewpager.R
import com.example.androidviewpager.databinding.FragmentThirdOnboardingBinding

class ThirdOnboardingFragment : Fragment() {
    private var _binding: FragmentThirdOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root

        init()

        return view
    }

    private fun init(){
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_homeFragment)
            onBoardingFinished()
        }
    }

    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onboarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("finished", true)
        editor.apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
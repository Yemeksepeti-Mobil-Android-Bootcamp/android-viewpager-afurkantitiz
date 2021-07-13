package com.example.androidviewpager.fragments.splash_screen

import android.animation.Animator
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidviewpager.R
import com.example.androidviewpager.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root

        initViews()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViews() {
        //A lottie animation to our splash screen
        binding.lottieAnimation.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                Log.v("Animation","Started")
            }

            override fun onAnimationEnd(animation: Animator?) {
                if(isOnboardingFinished()){
                    findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                }else{
                    findNavController().navigate(R.id.action_splashFragment_to_onboardingFragment)
                }
                //findNavController().navigate(R.id.action_splashFragment_to_onboardingFragment)
            }

            override fun onAnimationCancel(animation: Animator?) {
                Log.v("Animation","Canceled")
            }

            override fun onAnimationRepeat(animation: Animator?) {
                Log.v("Animation","Repeated")
            }
        })
    }

    private fun isOnboardingFinished(): Boolean {
        //To set up a shared preferences structure and check for Onboarding to show once after running
        val sharedPref = requireActivity().getSharedPreferences("onboarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("finished", false)
    }
}
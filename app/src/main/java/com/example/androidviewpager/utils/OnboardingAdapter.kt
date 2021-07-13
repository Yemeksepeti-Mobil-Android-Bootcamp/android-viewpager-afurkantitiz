package com.example.androidviewpager.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidviewpager.fragments.onboarding_screen.ErrorOnboardingFragment
import com.example.androidviewpager.fragments.onboarding_screen.FirstOnboardingFragment
import com.example.androidviewpager.fragments.onboarding_screen.SecondOnboardingFragment
import com.example.androidviewpager.fragments.onboarding_screen.ThirdOnboardingFragment

private const val FRAGMENT_COUNT = 3

class OnboardingAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    //We create a when structure for the page transitions of the viewpager and show that fragment according to the relevant position.

    override fun getItemCount(): Int = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstOnboardingFragment()
            1 -> SecondOnboardingFragment()
            2 -> ThirdOnboardingFragment()
            else -> ErrorOnboardingFragment()
        }
    }
}
package com.example.whereismytrain

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ExpressFragment()
            1 -> LocalFragment()
            2 -> MetroFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }

}
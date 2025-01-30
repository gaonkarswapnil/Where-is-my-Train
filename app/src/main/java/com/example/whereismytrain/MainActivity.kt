
package com.example.whereismytrain

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.whereismytrain.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        setSupportActionBar(binding.toolbar)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.open, R.string.close)

        toggle.drawerArrowDrawable.color = ContextCompat.getColor(this, android.R.color.white)

        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = when(position){
                0 -> "EXPRESS"
                1 -> "LOCAL"
                2 -> "METRO"
                else -> null
            }
        }.attach()
        viewPager.isUserInputEnabled = false
    }
}
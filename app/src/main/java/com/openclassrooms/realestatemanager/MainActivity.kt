package com.openclassrooms.realestatemanager

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.openclassrooms.realestatemanager.ui.real_estate_detail.RealEstateDetailFragment
import com.openclassrooms.realestatemanager.ui.real_estate_list.RealEstateListFragment

class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.main_toolbar)
        setSupportActionBar(toolbar)

        val navView = findViewById<NavigationView>(R.id.activity_main_navigation_view_menu)

        val drawer = findViewById<DrawerLayout>(R.id.main_drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            displayedFragment(0)
        }

        navView.setNavigationItemSelectedListener { menuItem: MenuItem ->
            if (menuItem.itemId == R.id.nav_real_estate_list) {
                displayedFragment(0)
            }
            if (menuItem.itemId == R.id.nav_real_estate_map) {
                displayedFragment(1)
            }
            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    private fun displayedFragment(fragmentNumber: Int) {
        val fragment: Fragment = when (fragmentNumber) {
            0 -> RealEstateListFragment.newInstance()
            1 -> RealEstateDetailFragment.newInstance()
            else -> throw IllegalStateException("Incorrect fragment number : $fragmentNumber")
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
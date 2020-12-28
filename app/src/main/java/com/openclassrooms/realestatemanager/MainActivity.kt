package com.openclassrooms.realestatemanager

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.openclassrooms.realestatemanager.ui.creation.CreationActivity
import com.openclassrooms.realestatemanager.ui.real_estate_detail.RealEstateDetailFragment
import com.openclassrooms.realestatemanager.ui.real_estate_list.RealEstateListFragment

class MainActivity : AppCompatActivity() {

    var mainFrameLayout: FrameLayout? = null

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

        mainFrameLayout = findViewById(R.id.fragment_container)

        if (isHandSetLayout()) {
            if (savedInstanceState == null) {
                displayedFragment(0)
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
        }
    }

    private fun isHandSetLayout(): Boolean = mainFrameLayout != null

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_activity_creation -> {
                val intent = Intent(this, CreationActivity::class.java)
                startActivity(intent)
        }
    }
    return super.onOptionsItemSelected(item)
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
package com.example.shop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.shop.R
import com.example.shop.screens.drawer.ContactFragment
import com.example.shop.screens.drawer.HomeFragment
import com.example.shop.screens.drawer.MessageFragment
import com.example.shop.screens.drawer.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer()
    }

    private fun drawer(){

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when(it.itemId){

                R.id.nav_home -> replaceFragment(HomeFragment(), it.title.toString())
                R.id.nav_message -> replaceFragment(MessageFragment(), it.title.toString())
                R.id.nav_settings -> replaceFragment(SettingsFragment(), it.title.toString())
                R.id.nav_contact -> replaceFragment(ContactFragment(), it.title.toString())

            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment, title: String){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){

            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
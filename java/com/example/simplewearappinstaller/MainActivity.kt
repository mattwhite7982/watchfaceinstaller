package com.example.simplewearappinstaller

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatDelegate
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle

    companion object {
        private const val PICK_APK_FILE = 1001
    }

     override fun onCreate(savedInstanceState: Bundle?) {
         AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         val toolbar: Toolbar = findViewById(R.id.toolbar)
         setSupportActionBar(toolbar)
         supportActionBar?.title = "Watch Face Installer"
         supportActionBar?.setDisplayShowTitleEnabled(true)

         drawerLayout = findViewById(R.id.drawer_layout)
         navView = findViewById(R.id.nav_view)

         navView.setNavigationItemSelectedListener { menuItem ->
             when (menuItem.itemId) {
                 R.id.nav_settings -> {
                     val rootView = findViewById<View>(android.R.id.content)
                     Snackbar.make(rootView, "coming soon", Snackbar.LENGTH_SHORT).show()
                 }
                 R.id.nav_about -> {
                     // TODO: Show about dialog
                 }
             }
             drawerLayout.closeDrawer(GravityCompat.START)
             true
         }

         // --- Restore your core functions below ---
         // Example: set up file picker button
         // findViewById<Button>(R.id.pickApkButton).setOnClickListener {
         //     val intent = Intent(Intent.ACTION_GET_CONTENT)
         //     intent.type = "application/vnd.android.package-archive"
         //     startActivityForResult(intent, PICK_APK_FILE)
         // }
         // Add your other core logic here
     } }
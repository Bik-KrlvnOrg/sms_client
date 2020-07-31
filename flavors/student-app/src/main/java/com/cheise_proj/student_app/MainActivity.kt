package com.cheise_proj.student_app

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {
    private val navController: NavController
        get() {
            return findNavController(R.id.fragment_nav_host)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = toolbar_main
        setSupportActionBar(toolbar)

        val bottomNavigationView = bottom_nav_main

        bottomNavigationView.setupWithNavController(navController )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
               R.id.dashboardFragment -> bottomNavigationView.visibility = View.VISIBLE
                else -> bottomNavigationView.visibility = View.GONE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}
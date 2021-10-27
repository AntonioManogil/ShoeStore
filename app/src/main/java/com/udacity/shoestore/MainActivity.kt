package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.viewmodels.ActivityViewModel

// There should only be one activity: MainActivity.
// Each screen should be a fragment.

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var viewModelActivity: ActivityViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main)
        navController = this.findNavController(R.id.myNavHostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph);
        viewModelActivity = ViewModelProvider(this).get(ActivityViewModel::class.java)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater : MenuInflater = menuInflater
//        inflater.inflate(R.menu.nav_menu, menu)
//        return true;
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId){
//            R.id.logout -> {
//                val navOption = NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build()
//                navController.navigate(R.id.loginFragment, null, navOption)
//                viewModelActivity.Clear()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//
//    }
}

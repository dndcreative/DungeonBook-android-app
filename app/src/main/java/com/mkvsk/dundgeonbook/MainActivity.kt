package com.mkvsk.dundgeonbook

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mkvsk.dundgeonbook.databinding.ActivityMainBinding
import com.mkvsk.dundgeonbook.viewmodel.SharedViewModel
import com.mkvsk.dundgeonbook.viewmodel.SkillViewModel
import com.mkvsk.dundgeonbook.viewmodel.UserViewModel


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var userViewModel: UserViewModel
    private lateinit var skillViewModel: SkillViewModel
    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var navController: NavController
    private lateinit var navView: BottomNavigationView

    private lateinit var healthStatsFragment: Fragment
    private lateinit var characterInfoFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        instantiateViewModels()

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigation()
        initViews()
        initListeners()
        initObservers()
    }

    private fun initViews() {
        healthStatsFragment = supportFragmentManager.findFragmentById(R.id.healthStats)!!
        characterInfoFragment = supportFragmentManager.findFragmentById(R.id.miniatureCharacterInfo)!!
    }

    private fun initObservers() {
        sharedViewModel.isHealthStatsVisible.observe(this) { isVisible ->
            healthStatsFragment.view?.visibility = if (isVisible) View.VISIBLE else View.GONE
        }

        sharedViewModel.isCharacterInfoVisible.observe(this) { isVisible ->
            characterInfoFragment.view?.visibility = if (isVisible) View.VISIBLE else View.GONE
        }

        sharedViewModel.isNavViewVisible.observe(this) { isVisible ->
            navView.visibility = if (isVisible) View.VISIBLE else View.GONE
        }

    }

    private fun initNavigation() {
        navView = binding.navView
        navController = findNavController(R.id.nav_host_fragment_activity_main)
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_auth_and_register, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {
            NavigationUI.onNavDestinationSelected(it, navController)
            return@setOnItemSelectedListener true
        }
    }

    private fun initListeners() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_auth_and_register -> {
                    sharedViewModel.setIsNavViewVisible(false)
                    sharedViewModel.setIsHealthStatsVisible(false)
                    sharedViewModel.setIsCharacterInfoVisible(false)

                }

                R.id.navigation_skills -> {
                    sharedViewModel.setIsNavViewVisible(false)
                    sharedViewModel.setIsHealthStatsVisible(false)
                    sharedViewModel.setIsCharacterInfoVisible(true)
                }

                else -> {
                    sharedViewModel.setIsNavViewVisible(true)
                    sharedViewModel.setIsHealthStatsVisible(true)
                    sharedViewModel.setIsCharacterInfoVisible(true)
                }
            }
        }
    }

    private fun instantiateViewModels() {
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        skillViewModel = ViewModelProvider(this)[SkillViewModel::class.java]
        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]
    }
}
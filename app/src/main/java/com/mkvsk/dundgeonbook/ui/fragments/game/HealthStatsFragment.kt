package com.mkvsk.dundgeonbook.ui.fragments.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mkvsk.dundgeonbook.databinding.FragmentHealthStatsBinding
import com.mkvsk.dundgeonbook.utils.MyAnimation.letFlying
import com.mkvsk.dundgeonbook.utils.MyAnimation.startFlightAnimation
import com.mkvsk.dundgeonbook.viewmodel.SharedViewModel
import com.mkvsk.dundgeonbook.viewmodel.PlayerViewModel

class HealthStatsFragment : Fragment() {

    private var _binding: FragmentHealthStatsBinding? = null
    private val binding get() = _binding!!

    private val playerViewModel by lazy { ViewModelProvider(this)[PlayerViewModel::class.java] }
    private val sharedViewModel by lazy { ViewModelProvider(this)[SharedViewModel::class.java] }

    private var healthPointsQty = 0
    private lateinit var bat: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHealthStatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleBackPressed()
        initViews()
        initListeners()
        initObservers()
    }

    private fun initViews() {
        bat = binding.btnExpand
        letFlying(bat)
        sharedViewModel.setIsHealthViewsExpanded(true)
    }

    private fun initListeners() {
        binding.apply {
            btnMinus.setOnClickListener { playerViewModel.setHealthPoints(healthPointsQty.dec()) }
            btnPlus.setOnClickListener { playerViewModel.setHealthPoints(healthPointsQty.inc()) }
            btnExpand.setOnClickListener {
                sharedViewModel.setIsHealthViewsExpanded(
                    !sharedViewModel.isHealthViewsExpanded.value!!
                )
            }
        }
    }

    private fun initObservers() {
//        playerViewModel.healthPoints.observe(viewLifecycleOwner) {
//            healthPointsQty = it
//            binding.tvCurrentHealthPoints.text = healthPointsQty.toString()
//        }

        sharedViewModel.isHealthViewsExpanded.observe(viewLifecycleOwner) {
            expandViews(it)
        }
    }

    private fun handleBackPressed() {

    }

    private fun expandViews(expand: Boolean) {
        binding.apply {
            btnPlus.isVisible = expand
            btnMinus.isVisible = expand
            ivMoon.isVisible = expand
            tvCurrentHealthPoints.isVisible = expand
            startFlightAnimation(expand, btnExpand)
        }
    }
}
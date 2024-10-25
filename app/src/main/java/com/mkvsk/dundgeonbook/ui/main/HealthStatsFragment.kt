package com.mkvsk.dundgeonbook.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mkvsk.dundgeonbook.databinding.FragmentHealthStatsBinding
import com.mkvsk.dundgeonbook.viewmodel.UserViewModel

class HealthStatsFragment: Fragment() {

    private var _binding: FragmentHealthStatsBinding? = null
    private val binding get() = _binding!!

    private val userViewModel by lazy { ViewModelProvider(this)[UserViewModel::class.java] }
    private var healthPointsQty = 0

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

    }

    private fun initListeners() {
        binding.let {
        it.btnMinus.setOnClickListener { userViewModel.setHealthPoints(healthPointsQty.dec()) }
        it.btnPlus.setOnClickListener { userViewModel.setHealthPoints(healthPointsQty.inc()) }
        }
    }

    private fun initObservers() {
        userViewModel.healthPoints.observe(viewLifecycleOwner) {
            healthPointsQty = it
            binding.tvCurrentHealthPoints.text = healthPointsQty.toString()
        }
    }

    private fun handleBackPressed() {

    }

}
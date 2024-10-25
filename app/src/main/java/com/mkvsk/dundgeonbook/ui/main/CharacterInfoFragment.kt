package com.mkvsk.dundgeonbook.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mkvsk.dundgeonbook.databinding.FragmentCharacterInfoBinding
import com.mkvsk.dundgeonbook.viewmodel.UserViewModel

class CharacterInfoFragment: Fragment() {

    private var _binding: FragmentCharacterInfoBinding? = null
    private val binding get() = _binding!!

    private val userViewModel by lazy { ViewModelProvider(this)[UserViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterInfoBinding.inflate(inflater, container, false)
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

    }

    private fun initObservers() {

    }

    private fun handleBackPressed() {

    }

}
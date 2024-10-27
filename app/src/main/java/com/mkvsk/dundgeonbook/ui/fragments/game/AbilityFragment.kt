package com.mkvsk.dundgeonbook.ui.fragments.game

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mkvsk.dundgeonbook.databinding.FragmentAbilityBinding
import com.mkvsk.dundgeonbook.databinding.FragmentEquipmentBinding
import com.mkvsk.dundgeonbook.viewmodel.UserViewModel

class AbilityFragment : Fragment() {

    private var _binding: FragmentAbilityBinding? = null
    private val binding get() = _binding!!

    private val userViewModel by lazy { ViewModelProvider(this)[UserViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAbilityBinding.inflate(inflater, container, false)
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
        binding.multilineEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        binding.multilineEditText.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->

        }
    }

    private fun initObservers() {

    }

    private fun handleBackPressed() {

    }

}
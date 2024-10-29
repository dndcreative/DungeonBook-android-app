package com.mkvsk.dundgeonbook.ui.fragments.authentication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.mkvsk.dundgeonbook.R
import com.mkvsk.dundgeonbook.databinding.FragmentAuthAndRegisterBinding
import com.mkvsk.dundgeonbook.utils.Constants
import com.mkvsk.dundgeonbook.viewmodel.AuthAndRegisterViewModel
import com.mkvsk.dundgeonbook.viewmodel.PlayerViewModel

class AuthAndRegisterFragment : Fragment() {
    private var _binding: FragmentAuthAndRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerViewModel: PlayerViewModel
    private lateinit var authAndRegisterViewModel: AuthAndRegisterViewModel

    private val login = ""
    private val password = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        playerViewModel = ViewModelProvider(requireActivity())[PlayerViewModel::class.java]
        authAndRegisterViewModel = ViewModelProvider(requireActivity())[AuthAndRegisterViewModel::class.java]
        _binding = FragmentAuthAndRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initViews()
        initListeners()
//        initObservers()

    }

    private fun initListeners() {
        binding.let {
            it.etLogin.addTextChangedListener(textWatcher())
            it.etPassword.addTextChangedListener(textWatcher())

            it.btnLogIn.setOnClickListener {
                if (authAndRegisterViewModel.userExist) {
                    openSkillsFragment()
                }
            }
        }
    }

    private fun textWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.btnLogIn.isEnabled =
                    binding.etLogin.text.length >= Constants.LOGIN_MIN_LENGTH
                            && binding.etPassword.text.length >= Constants.PASSWORD_MIN_LENGTH
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }
    }

    private fun openSkillsFragment() {
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_go_to_skills_from_register)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.mkvsk.dundgeonbook.ui.fragments.game

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.mkvsk.dundgeonbook.MainActivity
import com.mkvsk.dundgeonbook.core.Skill
import com.mkvsk.dundgeonbook.databinding.FragmentSkillsBinding
import com.mkvsk.dundgeonbook.ui.listeners.OnPointChangeListener
import com.mkvsk.dundgeonbook.viewmodel.SharedViewModel
import com.mkvsk.dundgeonbook.ui.adapters.SkillAdapter
import com.mkvsk.dundgeonbook.viewmodel.SkillViewModel
import com.mkvsk.dundgeonbook.viewmodel.UserViewModel

class SkillsFragment : Fragment(), OnPointChangeListener {

    private lateinit var mainActivity: MainActivity
    private var _binding: FragmentSkillsBinding? = null
    private val binding get() = _binding!!

    private val userViewModel by lazy { ViewModelProvider(this)[UserViewModel::class.java] }
    private val skillViewModel by lazy { ViewModelProvider(this)[SkillViewModel::class.java] }
    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var rv: RecyclerView
    private lateinit var adapter: SkillAdapter

    private var skills = ArrayList<Skill>()
    private var availablePoints: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSkillsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = (activity as? MainActivity)!!

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

//        handleBackPressed()
        setupAdapter()
        initViews()
        initListeners()
        initObservers()
        setData()
    }

    private fun setData() {
        val skill0 = Skill(0, "Strength", 10)
        val skill1 = Skill(1, "Perception", 10)
        val skill2 = Skill(2, "Endurance", 10)
        val skill3 = Skill(3, "Charisma", 10)
        val skill4 = Skill(4, "Intelligence", 10)
        val skill5 = Skill(5, "Agility", 10)
        val skill6 = Skill(6, "Luck", 10)

        skills.add(skill0)
        skills.add(skill1)
        skills.add(skill2)
        skills.add(skill3)
        skills.add(skill4)
        skills.add(skill5)
        skills.add(skill6)

        adapter.setData(skills)
        adapter.setAvailableQty(availablePoints)
    }

    private fun setupAdapter() {
        rv = binding.rvSkills
        adapter = SkillAdapter()
        adapter.setClickListener(this)
        rv.adapter = adapter
    }

    private fun initViews() {
        setupSkillsMode()
        binding.btnSave.isEnabled = true
    }

    private fun initListeners() {
        binding.let {
            it.tvAvailablePointsQty.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun afterTextChanged(p0: Editable?) {
                    it.btnSave.isEnabled = p0.toString().toInt() == 0
                }

            })

            it.btnSave.setOnClickListener {
                setupGameMode()
            }
        }
    }

    private fun setupSkillsMode() {
        sharedViewModel.setIsHealthStatsVisible(false)
        sharedViewModel.setIsNavViewVisible(false)
        binding.titlePoints.visibility = View.VISIBLE
        binding.titleAvailable.visibility = View.VISIBLE
        binding.ivBloodyMoon.visibility = View.VISIBLE
        binding.tvAvailablePointsQty.visibility = View.VISIBLE
        binding.btnSave.visibility = View.VISIBLE
        binding.titleSkillPoints.visibility = View.GONE
    }

    private fun setupGameMode() {
        sharedViewModel.setIsHealthStatsVisible(true)
        sharedViewModel.setIsNavViewVisible(true)
        binding.titlePoints.visibility = View.GONE
        binding.titleAvailable.visibility = View.GONE
        binding.ivBloodyMoon.visibility = View.GONE
        binding.tvAvailablePointsQty.visibility = View.GONE
        binding.btnSave.visibility = View.GONE
        binding.titleSkillPoints.visibility = View.VISIBLE
    }

    private fun initObservers() {
        skillViewModel.availablePoints.observe(viewLifecycleOwner) {
            if (it != null) {
                availablePoints = it
                binding.tvAvailablePointsQty.text = availablePoints.toString()
                adapter.setAvailableQty(availablePoints)
            }
        }
    }

    private fun handleBackPressed() {

    }


    private fun setAvailablePoints(value: Int) {
        skillViewModel.setAvailablePoints(value)
    }

    override fun onPointChangeListener(skill: Skill, availablePoints: Int) {
//        skillViewModel.setSkillValue(skill)
        setAvailablePoints(availablePoints)
    }
}
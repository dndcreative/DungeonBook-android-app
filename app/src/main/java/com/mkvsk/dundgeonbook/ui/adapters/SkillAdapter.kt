package com.mkvsk.dundgeonbook.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkvsk.dundgeonbook.core.Skill
import com.mkvsk.dundgeonbook.databinding.RvSkillItemBinding
import com.mkvsk.dundgeonbook.ui.listeners.OnPointChangeListener

class SkillAdapter :
    RecyclerView.Adapter<SkillAdapter.SkillItemViewHolder>() {

    private var data: ArrayList<Skill> = ArrayList()
    private lateinit var listener: OnPointChangeListener
    private var availableQty: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillItemViewHolder {
        val binding = RvSkillItemBinding
            .inflate(
                LayoutInflater
                    .from(parent.context), parent, false
            )
        return SkillItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SkillItemViewHolder, position: Int) {
        val skillItem = data.elementAt(position)
        holder.bind(skillItem)
    }

    fun setClickListener(listener: OnPointChangeListener) {
        this.listener = listener
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: ArrayList<Skill>?) {
        data?.let {
            this.data = it
            notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setAvailableQty(value: Int) {
        this.availableQty = value
    }

    inner class SkillItemViewHolder(rvSkillItemBinding: RvSkillItemBinding) :
        RecyclerView.ViewHolder(rvSkillItemBinding.root) {
        private val binding = rvSkillItemBinding

        fun bind(skillItem: Skill) {
            binding.tvTitle.text = skillItem.title
            binding.tvQty.text = skillItem.pointsQty.toString()

            binding.btnPlus.setOnClickListener {
                skillItem.pointsQty = skillItem.pointsQty.inc()
                listener.onPointChangeListener(
                    skillItem,
                    availableQty.inc()
                )
            }
            binding.btnMinus.setOnClickListener {
                skillItem.pointsQty = skillItem.pointsQty.dec()
                listener.onPointChangeListener(
                    skillItem,
                    availableQty.dec()
                )
            }
        }
    }
}

package com.example.xml_parsing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xml_parsing.databinding.ItemRowBinding


class RVAdapter(
    private val container: ArrayList<Students>
) :
    RecyclerView.Adapter<RVAdapter.CelebViewHolder>() {
    class CelebViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebViewHolder {
        return CelebViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CelebViewHolder, position: Int) {
        val cards = container[position]
        holder.binding.apply {
            tvId.text = cards.id.toString()
            tvName.text = cards.name
            tvGrade.text = cards.grade.toString()
        }
    }

    override fun getItemCount(): Int = container.size
}

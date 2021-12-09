package com.example.fourthlab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fourthlab.databinding.HumanBinding

interface IHumanClickListener {
    fun showHumanFio(name: String)
    fun showLikeHumanFio(name: String)
}
class HumanAdapter(private val clickListener: IHumanClickListener) :
    RecyclerView.Adapter<HumanAdapter.HumanViewHolder>() {
    class HumanViewHolder(var binding: HumanBinding) : RecyclerView.ViewHolder(binding.root)
    var humans: List<Human> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HumanViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HumanBinding.inflate(inflater, parent, false)
        return HumanViewHolder(binding)
    }
    override fun getItemCount(): Int = humans.size
    override fun onBindViewHolder(holder: HumanViewHolder, pos: Int) {
        val human = humans[pos]
        holder.itemView.setOnClickListener {
            clickListener.showHumanFio(human.fio)
        }
        with(holder.binding) {
            like.setOnClickListener { clickListener.showLikeHumanFio(human.fio) }
            fio.text = human.fio
            date.text = human.date
            description.text = human.description
            gender.text = human.gender
            if (human.imagePath.isNotBlank())
                Glide.with(photo.context)
                    .load(human.imagePath).circleCrop().placeholder(R.drawable.ic_photo).into(photo)
            else
                photo.setImageResource(R.drawable.ic_photo)
        }
    }
}

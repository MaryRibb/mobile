package com.example.fourthlab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fourthlab.databinding.HumanBinding

interface IHumanClickListener {
    fun showHumanFio(name: String)

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
        val pictureRus = R.drawable.ic_photo

        holder.itemView.setOnClickListener {
            clickListener.showHumanFio(human.fio)
        }
        with(holder.binding) {

            fio.text = human.fio
            name.text = human.name
            text.text = human.text


            Glide.with(photo.context)
                    .load(human.imagePath).centerCrop().placeholder(pictureRus).into(photo)

        }
    }
}

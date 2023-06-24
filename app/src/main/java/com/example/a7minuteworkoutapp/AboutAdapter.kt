package com.example.a7minuteworkoutapp

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minuteworkoutapp.databinding.ActivityAboutExercisesBinding
import com.example.a7minuteworkoutapp.databinding.ItemAboutExerciseBinding


class AboutAdapter(val aboutExerciseList:List<AboutExercise>):RecyclerView.Adapter<AboutAdapter.AboutExerciseViewHolder>() {
    inner class AboutExerciseViewHolder(val itemBinding:ItemAboutExerciseBinding):RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(aboutExercise: AboutExercise){
            itemBinding.tvAboutExercise.text = aboutExercise.aboutText
            itemBinding.ExerciseName.text = aboutExercise.exerciseName
            itemBinding.ExercisePic.setImageResource(aboutExercise.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutExerciseViewHolder {
        return AboutExerciseViewHolder(ItemAboutExerciseBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return aboutExerciseList.size
    }

    override fun onBindViewHolder(holder: AboutExerciseViewHolder, position: Int) {
        val abtExercise = aboutExerciseList[position]
        holder.bindItem(abtExercise)
    }
}
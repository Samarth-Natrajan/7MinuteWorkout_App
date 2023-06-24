package com.example.a7minuteworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a7minuteworkoutapp.databinding.ActivityAboutExercisesBinding

class AboutExercisesActivity : AppCompatActivity() {
    private var binding:ActivityAboutExercisesBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutExercisesBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarAboutExercise)
        if(supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "About the exercises"
        }
        binding?.toolbarAboutExercise?.setNavigationOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
        val adapter = AboutAdapter(AboutList.aboutList)
        binding?.aboutExerciseRv?.adapter = adapter
        binding?.aboutExerciseRv?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)



    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
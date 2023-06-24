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
            supportActionBar?.title = "About Us"
        }
        binding?.toolbarAboutExercise?.setNavigationOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
        val adapter = AboutAdapter(AboutList.aboutList)
        binding?.aboutExerciseRv?.adapter = adapter
        binding?.aboutExerciseRv?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding?.tvAbout?.text = "Perform high intensity exercises for 7 minutes.Track your health and fitness using a BMI calculator and history page which lists your exercises.Check out on how to do each exercise in the app below before starting.\n" + "ALL THE BEST!"



    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
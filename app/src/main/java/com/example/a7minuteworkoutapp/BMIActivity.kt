package com.example.a7minuteworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.a7minuteworkoutapp.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    companion object{
        private const val METRIC_UNITS_VIEW = "METRIC_UNIT_VIEW"
        private const val US_UNITS_VIEW = "US_UNIT_VIEW"
    }
    private var currentVisibleView:String = METRIC_UNITS_VIEW

    private var binding :ActivityBmiBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarBmiActivity)
        if(supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "Calculate BMI"
        }
        binding?.toolbarBmiActivity?.setNavigationOnClickListener{
            //onBackPressedDispatcher.onBackPressed()
            onBackPressedDispatcher.onBackPressed()
        }
        makeVisibleMetricView()
        binding?.rgUnits?.setOnCheckedChangeListener { _, checkedId :Int ->
            if(checkedId == R.id.rbMetricUnits){
                makeVisibleMetricView()
            }
            else{
                makeVisibleUSView()
            }
        }
        binding?.btnCalculateBMI?.setOnClickListener {
            if(validateMetricUnits()&&currentVisibleView== METRIC_UNITS_VIEW){
                val height : Float = binding?.etMetricUnitHeight?.text?.toString()!!.toFloat()/100
                val weight : Float = binding?.etMetricUnitWeight?.text?.toString()!!.toFloat()
                val bmi = weight/(height*height)
                displayBMIResult(bmi)

            }
            else if(validateUsUnits()&&currentVisibleView== US_UNITS_VIEW) {
                val heightF: Float = binding?.etMetricUnitHeightFeet?.text?.toString()!!.toFloat()
                val heightI: Float = binding?.etMetricUnitHeightInches?.text?.toString()!!.toFloat() + 12*heightF

                val weightP: Float = binding?.etMetricUnitWeightPound?.text?.toString()!!.toFloat()
                val bmi = (weightP/(heightI*heightI))*703
                displayBMIResult(bmi)
            }
            else{
                Toast.makeText(this@BMIActivity,"please enter valid values",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun validateMetricUnits():Boolean{
        var isValid = true
        if(binding?.etMetricUnitWeight?.text?.toString()!!.isEmpty()){
            isValid = false
        }
        else if(binding?.etMetricUnitHeight?.text?.toString()!!.isEmpty()){
            isValid = false
        }
        return isValid
    }
    private fun validateUsUnits():Boolean{
        var isValid = true
        if(binding?.etMetricUnitWeightPound?.text?.toString()!!.isEmpty()){
            isValid = false
        }
        else if(binding?.etMetricUnitHeightFeet?.text?.toString()!!.isEmpty()){
            isValid = false
        }
        else if(binding?.etMetricUnitHeightInches?.text?.toString()!!.isEmpty()){
            isValid = false
        }
        return isValid
    }

    private fun makeVisibleMetricView(){
        currentVisibleView = METRIC_UNITS_VIEW
        binding?.tilMetricUnitHeight?.visibility = View.VISIBLE
        binding?.tilMetricUnitWeight?.visibility = View.VISIBLE
        binding?.tilMetricUnitWeightPound?.visibility = View.INVISIBLE
        binding?.tilMetricUnitHeightFeet?.visibility = View.INVISIBLE
        binding?.tilMetricUnitHeightInches?.visibility = View.INVISIBLE
        binding?.llDisplayBMIResult?.visibility = View.INVISIBLE
    }
    private fun makeVisibleUSView(){
        currentVisibleView = US_UNITS_VIEW
        binding?.tilMetricUnitHeight?.visibility = View.INVISIBLE
        binding?.tilMetricUnitWeight?.visibility = View.INVISIBLE
        binding?.tilMetricUnitWeightPound?.visibility = View.VISIBLE
        binding?.tilMetricUnitHeightFeet?.visibility = View.VISIBLE
        binding?.tilMetricUnitHeightInches?.visibility = View.VISIBLE
        binding?.llDisplayBMIResult?.visibility = View.INVISIBLE
    }


    private fun displayBMIResult(BMI:Float){
        val BMILabel : String
        val BMIDescription : String
        if(BMI.compareTo(15f) <= 0){
            BMILabel = "Very Severely underweight"
            BMIDescription = "Oops! you really need to take better care of yourself! Eat more and workout more!"
        }
        else if(BMI.compareTo(15f) > 0 && BMI.compareTo(16f) <= 0){
            BMILabel = "Severely underweight"
            BMIDescription = "Oops! you really need to take better care of yourself! Eat more and workout more!"
        }
        else if(BMI.compareTo(16f) > 0 && BMI.compareTo(18.5f) <= 0){
            BMILabel = "underweight"
            BMIDescription = "Oops! you really need to take better care of yourself! Eat more and workout more!"
        }
        else if(BMI.compareTo(18.5f) > 0 && BMI.compareTo(25f) <= 0){
            BMILabel = "Normal"
            BMIDescription = "Congratulations! You are in good shape"
        }
        else if(BMI.compareTo(25f) > 0 && BMI.compareTo(30f) <= 0){
            BMILabel = "OverWeight"
            BMIDescription = "Oops! You really need to take care of your self! Eat less and workout more"
        }
        else if(BMI.compareTo(30f) > 0 && BMI.compareTo(35f) <= 0){
            BMILabel = "Moderately Obese"
            BMIDescription = "Oops! You really need to take care of your self! Eat less and workout more"
        }
        else if(BMI.compareTo(35f) > 0 && BMI.compareTo(40f) <= 0){
            BMILabel = "Severely Obese"
            BMIDescription = "OMG! You are in a dangerous condtion! Act now!"
        }
        else{
            BMILabel = "how are you alive"
            BMIDescription = "Bhagwaan he bacha sakta hai aapko"
        }
        val bmivalue = BigDecimal(BMI.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()
        binding?.tvBMIType?.text = BMILabel
        binding?.tvBMIDescription?.text = BMIDescription
        binding?.tvBMIValue?.text = bmivalue
        binding?.llDisplayBMIResult?.visibility = View.VISIBLE

    }
}
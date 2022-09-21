package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDataBinding
import com.example.myapplication.databinding.ActivityMainBinding

class DataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingData: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingData = ActivityDataBinding.inflate(layoutInflater)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingData.root);
    }

    fun goBack(v: View?) {
        updateMortgageObject()
        finish()
    }

    fun updateMortgageObject()
    { val p = Prefs(this)
        val amountET = bindingData.dataAmount
        val rb10 = bindingData.ten
        val rb15 = bindingData.fifteen
        var years = 30

        if (rb10.isChecked)
            years = 10
        else if (rb15.isChecked)
            years = 15

        Mortgage.setYears(years)
        val rateET = bindingData.dataRate
        val rateString:String = rateET.getText().toString()
        val amountString = amountET.text.toString()
        Log.d("KUPAL", amountString)
        binding.amount.text = amountString
        Log.d("KUPAL", binding.amount.text.toString())
        try {
            val amount = amountString.toFloat()
            Mortgage.setAmount(amount)
            Log.d("KUPALMort", Mortgage.getFormattedAmount().toString())
            val rate: Float = rateString.toFloat()
            Mortgage.setRate(rate)
            p.setPreferences(Mortgage)
        } catch (nfe: NumberFormatException) {
            Mortgage.setAmount(100000.0f)
            Mortgage.setRate(.035f)
        }
    }
}
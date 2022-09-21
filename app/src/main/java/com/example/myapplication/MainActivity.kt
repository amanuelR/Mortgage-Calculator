package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val pf:Prefs = Prefs(this)
    var mortgage = Mortgage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        pf.setPreferences(mortgage)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.amount.text = Mortgage.getFormattedAmount().toString()
        Log.d("KUPALMortMain", Mortgage.getFormattedAmount().toString())
    }
    fun modifyData(view: View) {
        val myIntent = Intent(this, DataActivity::class.java)
        Log.d("KUPALMortMain", Mortgage.getFormattedAmount().toString())
        binding.amount.text = Mortgage.getFormattedAmount().toString()
        this.startActivity(myIntent)

    }
}
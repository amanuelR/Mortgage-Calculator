package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class Prefs (context1: Context) {
    private var context: Context? = context1
    private var amount:Float = 200000.0f
    private var years: Int = 15
    private var rate: Float =0.035f


    fun setPreferences(mort: Mortgage) {
        var s: SharedPreferences? = context!!.getSharedPreferences("Mortgage", Context.MODE_PRIVATE)
        var editor = s?.edit()
        editor?.clear()

        if (editor != null) {
            editor.putFloat("PREFERENCE_AMOUNT", mort.getAmount())
        }
        if (editor != null) {
            editor.putInt("PREFERENCE_YEARS", mort.getYears())
        }
        if (editor != null) {
            editor.putFloat("PREFERENCE_RATE", mort.getRate())
        }
        editor?.apply()
        Log.d("InPrefs", s?.all.toString())
    }
    fun getPreferences(mort: Mortgage) {
        var s: SharedPreferences? = context!!.getSharedPreferences("Mortgage", Context.MODE_PRIVATE)
        if (s != null) {
            mort.setAmount(s.getFloat("PREFERENCE_AMOUNT", 100000.0f))
            mort.setYears(s.getInt("PREFERENCE_YEARS", 30))
            mort.setRate(s.getFloat("PREFERENCE_RATE", 0.035f))
        }
    }
}
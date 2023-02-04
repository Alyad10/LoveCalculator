package com.example.lovecalculator.local

import android.content.Context

class Pref(private val context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun setOnBoardingSeen(isSeen: Boolean){
        pref.edit().putBoolean(ON_BOARDING_SEEN, isSeen).apply()
    }
    fun isOnBoardingView(): Boolean{
        return pref.getBoolean(ON_BOARDING_SEEN, true)
    }
    companion object{
        private const val ON_BOARDING_SEEN = "is_seen"
        private const val PREF_NAME = "pref_love_calculator"
    }

}
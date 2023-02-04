package com.example.lovecalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.lovecalculator.local.Pref
import com.example.lovecalculator.onboard.OnBoardActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StartActivity : AppCompatActivity() {

    @Inject
     lateinit var pref : Pref


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

            Handler().postDelayed({
                if(pref.isOnBoardingView()){
                    startActivity(Intent(this, OnBoardActivity::class.java))
                }else{
                    startActivity(Intent(this, MainActivity::class.java))
                }

                finish()
            }, 1000)


    }
}
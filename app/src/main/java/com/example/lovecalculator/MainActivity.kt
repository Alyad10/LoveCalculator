package com.example.lovecalculator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.remote.RetrofitService
import com.example.lovecalculator.viewmodel.LoveViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }
    companion object{
const val INTENT_FOR_RESULT = "RESULT"
    }

    private fun initClickers() {
        with(binding){
            btnCalculate.setOnClickListener {
               viewModel.getLiveLove(etFname.text.toString(),edSname.text.toString()).
               observe(this@MainActivity, Observer {
                   Log.e("ololo", "initClickers: ${it.percentage}")
               })
            }
        }
    }
}
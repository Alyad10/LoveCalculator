package com.example.lovecalculator
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculator.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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
                RetrofitService().api.calculateLove(
                    etFname.text.toString(),
                    edSname.text.toString()
                )
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            if (response.isSuccessful){
                                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                                intent.putExtra(INTENT_FOR_RESULT, response.body())
                                startActivity(intent)
                            }else{
                                Toast.makeText(this@MainActivity, "Что то пошло не очень", Toast.LENGTH_SHORT).show()

                            }
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Toast.makeText(this@MainActivity, "Что то пошло не так", Toast.LENGTH_SHORT).show()
                        }

                    })
            }
        }
    }
}
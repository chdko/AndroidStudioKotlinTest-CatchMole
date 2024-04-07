package com.cihank.catchtomole

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cihank.catchtomole.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var bestScore: Int = 0
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        sharedPreferences = this@MainActivity.getSharedPreferences("com.cihank.catchtomole", Context.MODE_PRIVATE)

        bestScore = sharedPreferences.getInt("newBestScore", 99)

        newScore()

    }

    fun playButton(view: View){
        val intent = Intent(this, PlayGameActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun newScore(){
        // Veriyi alan aktivite (HedefActivity)
        val gelenveri = intent.getIntExtra("newscore", 0)
        binding.newScoreView.text = "New Score: $gelenveri"

        if (gelenveri > bestScore){
            bestScore = gelenveri
            sharedPreferences.edit().putInt("newBestScore", bestScore).apply()
            binding.bestScoreView.text = "Best Score: $gelenveri"
        }else{
            //bestScore = sharedPreferences.getInt("newBestScore", 99)
            binding.bestScoreView.text = "Best Score: $bestScore"
        }
    }
}
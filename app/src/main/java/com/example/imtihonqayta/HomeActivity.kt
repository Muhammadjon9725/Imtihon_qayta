package com.example.imtihonqayta

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.example.imtihonqayta.databinding.ActivityHomeBinding
import com.example.imtihonqayta.model.MyObjeckt


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE)

        val color = sharedPreferences.getString("color", "#FFFFFF")
        binding.root.setBackgroundColor(Color.parseColor(color))

        if (MyObjeckt.color != null) {
            binding.homeactivity.background = MyObjeckt.color
        }
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        setContentView(binding.homeactivity)
        if (MyObjeckt.color != null) {
            binding.homeactivity.background = MyObjeckt.color
        }
    }

}
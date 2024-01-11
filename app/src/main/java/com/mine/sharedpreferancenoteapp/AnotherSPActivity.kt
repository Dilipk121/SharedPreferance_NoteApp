package com.mine.sharedpreferancenoteapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mine.sharedpreferancenoteapp.databinding.ActivityAnotherSpactivityBinding
import com.mine.sharedpreferancenoteapp.databinding.ActivityMainBinding

class AnotherSPActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnotherSpactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnotherSpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("noteApp", Context.MODE_PRIVATE)

        val ac_nn = sharedPreferences.getString("noteActivity","")

        binding.spTv.text = ac_nn

        binding.backBtn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }




    }
}
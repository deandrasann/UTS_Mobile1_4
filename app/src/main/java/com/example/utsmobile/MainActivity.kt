package com.example.utsmobile

import android.content.Intent
import android.widget.Toast
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.utsmobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //bind
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //bind
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        with(binding) {
            btnSubmit.setOnClickListener {
                val intentTosecondActivity = Intent(this@MainActivity, SecondActivity::class.java)
                val name = txtEditName.text.toString()
                intentTosecondActivity.putExtra("EXTRA USERNAME", txtEditName.text.toString())

                if (name == ""){
                    Toast.makeText(this@MainActivity, "Enter your name first", Toast.LENGTH_SHORT).show()
                }
                else {
                    startActivity(intentTosecondActivity)
                }
            }
        }
    }
}
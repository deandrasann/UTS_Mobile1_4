package com.example.utsmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.example.utsmobile.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username =intent.getStringExtra("EXTRA USERNAME")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        with (binding){
            txtUsn.text = username
            btnKeluar.setOnClickListener {
                val intentToThirdActivity = Intent(this@SecondActivity, ThirdActivity::class.java)
//                Toast.makeText(this, "You have successfully logged out", Toast.LENGTH_SHORT).show()
//                Toast.makeText(this, "You have successfully logged out", Toast.LENGTH_SHORT).show()
                Toast.makeText(this@SecondActivity, "You have successfully logged out", Toast.LENGTH_SHORT).show()
                startActivity(intentToThirdActivity)
            }
        }
    }
}
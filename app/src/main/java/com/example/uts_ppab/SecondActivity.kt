package com.example.uts_ppab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.uts_ppab.databinding.ActivityMainBinding
import com.example.uts_ppab.databinding.ActivitySecondBinding
import com.example.uts_ppab.MainActivity.Companion.TEXT_EXTRA

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val username = intent.getStringExtra(TEXT_EXTRA)
            val password = intent.getStringExtra(TEXT_EXTRA)

            btnLogin.setOnClickListener(){
                if (
                    inputPassword.text.toString() == password ||
                    inputUsername.text.toString() == username){

                    val intentToThirdActivity =
                        Intent(this@SecondActivity, ThirdActivity::class.java)
                    startActivity(intentToThirdActivity)
                }
                else{
                    Toast.makeText( this@SecondActivity,"USERNAME ATAU PASSWORD SALAH", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
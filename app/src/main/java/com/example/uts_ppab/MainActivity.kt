package com.example.uts_ppab

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.uts_ppab.databinding.ActivityMainBinding
import java.util.Date
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object{
        const val TEXT_EXTRA = "text_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun isEmailValid(email: String): Boolean {
            val pattern = android.util.Patterns.EMAIL_ADDRESS
            return pattern.matcher(email).matches()
        }
        fun isUsernameValid(username: String): Boolean {
            return username.isNotBlank() && username.length >= 4
        }
        fun isPasswordValid(password: String): Boolean {
            return password.length >= 8
        }

        with(binding){
            btnRegister.setOnClickListener(){
                val email = inputEmail.text.toString()
                val username = inputUsername.text.toString()
                val password = inputPassword.text.toString()
                val confirmPassword = inputConfirmPassword.text.toString()

                if (inputEmail.text.isEmpty()   ||
                    inputPassword.text.isEmpty()||
                    inputUsername.text.isEmpty()||
                    inputConfirmPassword.text.isEmpty() ||
                    inputBirthday.text.isEmpty()
                ){
                    val warning = "tolong isi seluruh data dengan benar."
                    Toast.makeText(this@MainActivity, warning, Toast.LENGTH_SHORT).show()
                }
                else {
                    if (isEmailValid(email) &&
                        isUsernameValid(username) &&
                        isPasswordValid(password)
                        ){
                        val username = inputUsername.text.toString()
                        val password = inputPassword.text.toString()

                        val intentToSecondActivity =
                            Intent(this@MainActivity, SecondActivity::class.java)
                        intentToSecondActivity.putExtra(TEXT_EXTRA, username)
                        intentToSecondActivity.putExtra(TEXT_EXTRA, password)
                        startActivity(intentToSecondActivity)
                    } else {
                        Toast.makeText(this@MainActivity, "Silakan periksa input Anda.", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}

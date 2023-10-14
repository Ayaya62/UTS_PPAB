package com.example.uts_ppab

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.uts_ppab.FourthActivity.Companion.EXTRA_DATE
import com.example.uts_ppab.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result ->
            //should Update UI

            if(result.resultCode == Activity.RESULT_OK){
                val data = result.data
                val date = data?.getStringExtra(EXTRA_DATE)

                binding.txtTgl.text = "Anda memiliki rencana perjalanan pada tanggal $date"
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityThirdBinding.inflate((layoutInflater))
        setContentView(binding.root)

        with(binding){
            btnMakePlan.setOnClickListener(){
                val intent = Intent(this@ThirdActivity, FourthActivity::class.java)
                launcher.launch(intent)
            }

        }
    }
}
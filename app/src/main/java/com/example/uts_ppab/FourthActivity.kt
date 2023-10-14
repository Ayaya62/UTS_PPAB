package com.example.uts_ppab

import android.R
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.uts_ppab.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding
    companion object{
        const val EXTRA_DATE = "extra_date"
        const val EXTRA_CLASS = "extra_class"
        const val EXTRA_ASAL = "extra_asal"
        const val EXTRA_TUJUAN = "extra_tujuan"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate((layoutInflater))
        setContentView(binding.root)

        val stasiun = arrayOf(
            "Stasiun Tugu - Yogyakarta",
            "Stasiun Cimahi - Bandung",
            "Stasiun Semarang Tawang - Semarang",
            "Stasiun Gambir - Jakarta",
            "Stasiun Blimbing - Malang",
            "Stasiun Gubeng - Surabaya",
            "Stasiun Solo Balapan - Solo"
        )

        val classKereta = arrayOf(
            "Ekonomi",
            "Bisnis",
            "Eksekutif",
            "Prioritas",
            "Luxury"
        )

        with(binding){
            val adapterStasiun = ArrayAdapter<String>(this@FourthActivity,
                R.layout.simple_spinner_item, stasiun)
            spinnerAsal.adapter = adapterStasiun

            val adapterTujuan = ArrayAdapter<String>(this@FourthActivity,
                R.layout.simple_spinner_item, stasiun)
            spinnerTujuan.adapter = adapterTujuan

            val adapterClass = ArrayAdapter<String>(this@FourthActivity,
                R.layout.simple_spinner_item, classKereta)
            spinnerClass.adapter = adapterClass

            var totalHarga = 0

            fun updateText(){
                txtHarga.text = "harga : Rp${totalHarga}"
            }

            btnGerbongBelakang.setOnClickListener(){
                totalHarga += 10000
                updateText()
            }
            btnMakan.setOnClickListener(){
                totalHarga += 20000
                updateText()
            }
            btnMinum.setOnClickListener(){
                totalHarga += 5000
                updateText()
            }
            btnWifi.setOnClickListener(){
                totalHarga +=30000
                updateText()
            }
            btnGerbongDepan.setOnClickListener(){
                totalHarga += 25000
                updateText()
            }
            btnKursiJendela.setOnClickListener(){
                totalHarga += 30000
                updateText()
            }
            btnKursiBaring.setOnClickListener(){
                totalHarga += 40000
                updateText()
            }

            var kelasKereta = ""

            spinnerClass.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    // Ambil kelas kereta yang dipilih
                    val kelasKereta = classKereta[position]

                    // Hitung harga berdasarkan kelas kereta yang dipilih
                    val hargaKelas = when (kelasKereta) {
                        "Ekonomi" -> 200000
                        "Bisnis" -> 350000
                        "Eksekutif" -> 500000
                        "Prioritas" -> 750000
                        "Luxury" -> 1000000
                        else -> 0
                    }
                    totalHarga += hargaKelas
                    updateText()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Tidak ada tindakan yang diperlukan ketika tidak ada yang dipilih
                }
            }

            var selectedDate = ""

            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ){ _, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month+1}/$year"
            }


            btnToDashboard.setOnClickListener(){
                val tanggal = selectedDate
                val kereta = kelasKereta
                val intent = Intent()
                intent.putExtra(EXTRA_DATE, tanggal)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

        }
    }
}
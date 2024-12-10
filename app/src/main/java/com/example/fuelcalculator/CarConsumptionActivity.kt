package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fuelcalculator.databinding.ActivityCarConsumptionBinding
import com.google.android.material.snackbar.Snackbar

class CarConsumptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarConsumptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarConsumptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val next = binding.btnNext

        next.setOnClickListener {
            if (binding.textInputEditText.text.toString().isEmpty()) {
                Snackbar.make(next, "Please enter your car consumption", Snackbar.LENGTH_SHORT)
                    .show()
            }
            else {
                UserInfo.consumption_data =
                    binding.textInputEditText.text.toString().toFloatOrNull()
                val nextstep = Intent(this, GasPriceActivity::class.java)
                startActivity(nextstep)
            }
        }
    }
}
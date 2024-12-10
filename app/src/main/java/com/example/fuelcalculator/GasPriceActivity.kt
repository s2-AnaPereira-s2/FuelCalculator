package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fuelcalculator.databinding.ActivityGasPriceBinding
import com.google.android.material.snackbar.Snackbar

class GasPriceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGasPriceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGasPriceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val next = binding.btnNext

        next.setOnClickListener {
            if (binding.priceInputEditText.text.toString().isEmpty()) {
                Snackbar.make(next, "Please enter the current price per litre", Snackbar.LENGTH_SHORT)
                    .show()
            }

            else {
                UserInfo.price_data = binding.priceInputEditText.text.toString().toFloatOrNull()

                val distance_calculation = UserInfo.distance_data.toString().toFloat()
                val consumption_calculation = UserInfo.consumption_data.toString().toFloat()
                val price_calculation = UserInfo.price_data.toString().toFloat()

                val trip_liters = distance_calculation / consumption_calculation
                val trip_price = trip_liters * price_calculation

                UserInfo.total_data = trip_price

                val laststep = Intent(this, ResultActivity::class.java)
                startActivity(laststep)
            }
        }
    }
}
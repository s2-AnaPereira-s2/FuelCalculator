package com.example.fuelcalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.example.fuelcalculator.databinding.ActivityDestinationBinding
import com.google.android.material.snackbar.Snackbar

class DestinationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDestinationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val next = binding.btnNext

        next.setOnClickListener {
            if (binding.destinationInputEditText.text.toString().isEmpty() || binding.distanceInputEditText.text.toString().isEmpty()) {
                Snackbar.make(next, "Please enter the destination and distance", Snackbar.LENGTH_SHORT)
                    .show()
            }
            else {
                UserInfo.distance_data = binding.distanceInputEditText.text.toString().toFloat()
                UserInfo.destination_data =
                    binding.destinationInputEditText.text.toString().split(" ")
                        .joinToString(" ") { word -> word.replaceFirstChar { it.titlecase() } }

                val nextstep = Intent(this, CarConsumptionActivity::class.java)
                startActivity(nextstep)
            }
        }
    }
}
package com.example.fuelcalculator

import android.content.Intent
import com.example.fuelcalculator.databinding.ActivityResultBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val distance_input = UserInfo.distance_data
        val distance_view = binding.distance
        distance_view.text = distance_input.toString()

        val price_input = UserInfo.price_data
        val price_view = binding.price
        price_view.text = price_input.toString()

        val username_input = UserInfo.username_data
        val username_view = binding.username
        username_view.text = username_input


        val destination_input = UserInfo.destination_data
        val destination_view = binding.destination
        destination_view.text = destination_input

        val consumption_input = UserInfo.consumption_data
        val consumption_view = binding.consumption
        consumption_view.text = consumption_input.toString()

        val result_amount = UserInfo.total_data
        val result_view = binding.amount
        result_view.text = result_amount.toString()

        val new = binding.newplan

        new.setOnClickListener {
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        }
    }
}
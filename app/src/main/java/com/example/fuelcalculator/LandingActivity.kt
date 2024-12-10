package com.example.fuelcalculator
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.fuelcalculator.databinding.ActivityLandingBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Locale

class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val start = binding.btnStart

        start.setOnClickListener {
            if (binding.UsernameInputEditText.text.toString().isEmpty()) {
                Snackbar.make(start, "Please enter your name", Snackbar.LENGTH_SHORT)
                    .show()
            }
            else {
                UserInfo.username_data = binding.UsernameInputEditText.text.toString().split(" ")
                    .joinToString(" ") { word -> word.replaceFirstChar { it.titlecase() } }

                val nextstep = Intent(this, DestinationActivity::class.java)
                startActivity(nextstep)
            }
        }
    }
}
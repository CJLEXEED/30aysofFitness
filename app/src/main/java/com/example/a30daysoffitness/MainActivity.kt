package com.example.a30daysoffitness

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Enable edge-to-edge display
        setContentView(R.layout.activity_main)  // Set the content view

        // Set up the RecyclerView
        val fitnessTips = getFitnessTips()  // Get the list of fitness tips
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)  // Find the RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)  // Set layout manager
        recyclerView.adapter = FitnessTipsAdapter(fitnessTips)  // Set adapter

        // Handle window insets for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Function to get fitness tips (ensure this function is defined in your MainActivity)
    private fun getFitnessTips(): List<FitnessTip> {
        return listOf(
            FitnessTip(1, "Start with a Warm-up", "Warm up with 5 minutes of light cardio.", R.drawable.warmup),
            FitnessTip(2, "Full-body Stretch", "Do a full-body stretch to improve flexibility.", R.drawable.stretch),
            FitnessTip(3, "Push-ups", "Perform 20 push-ups to build upper body strength.", R.drawable.pushups)
            // Add additional fitness tips here...
        )
    }
}

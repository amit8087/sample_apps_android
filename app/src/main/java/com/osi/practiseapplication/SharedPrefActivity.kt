package com.osi.practiseapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.osi.practiseapplication.databinding.ActivitySharedPrefBinding

class SharedPrefActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySharedPrefBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPrefBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displaySavedText()
        binding.btnSaveMe.setOnClickListener {
            val enteredText = binding.etSharedPref.text.toString()
            displayAndSaveText(enteredText)
        }
    }

    // Retrieving the value from SharedPref
    private fun displaySavedText() {
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val s1 = sharedPreferences.getString("name", " ")
        binding.tvSharedPref.text = s1
    }

    private fun displayAndSaveText(enteredText: String) {
        // Display the Text
        binding.tvSharedPref.text = enteredText

        // Saving the Text into SharedPref
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)

        // Writing data to shared pref
        val editor = sharedPreferences.edit()
        editor.putString("name", enteredText)
        editor.apply()

//        // Deleting the sahred pref
//        editor.remove("name")
//        editor.apply()
    }
}
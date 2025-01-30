package com.example.whereismytrain

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.whereismytrain.databinding.ActivityTicketBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class TicketActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTicketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbarTickets)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_home)
        binding.toolbarTickets.overflowIcon?.setTint(getColor(R.color.white))
        supportActionBar?.title = "TICKETS"


        val quotaList = listOf("General", "Ladies", "Senior Citizen", "Tatkal", "Premium Tatkal")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, quotaList)
        binding.spinnerQuota.adapter = adapter




        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        binding.selectedJD.setText(dateFormat.format(calendar.time))


        binding.selectedJD.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Update EditText with selected date
                    val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    binding.selectedJD.setText(selectedDate)
                },
                year,
                month,
                day
            )

            datePickerDialog.datePicker.minDate = calendar.timeInMillis

            datePickerDialog.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.prn_menu, menu) // Inflate the menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    }
}
package com.example.age_in_minutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var dateSelected: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePicker: Button = findViewById(R.id.datePickerButton)
        dateSelected = findViewById(R.id.displayDate)
        datePicker.setOnClickListener {
            datePickerHandler()
        }
    }

    fun datePickerHandler(){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{view, selectedYear, selectedMonth, selectedDayOfMonth ->
//                Toast.makeText(this, "$selectedDayOfMonth / ${selectedMonth + 1} / $selectedYear", Toast.LENGTH_LONG).show()
                val theDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                dateSelected?.text = theDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val sdfDate = sdf.parse(theDate)

            },
            year, month, day

        ).show()
//        Toast.makeText(this, "$day $month $year", Toast.LENGTH_LONG).show()

    }
}
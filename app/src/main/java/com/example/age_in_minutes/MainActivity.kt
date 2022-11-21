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
    private var minutesDisplay: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePicker: Button = findViewById(R.id.datePickerButton)
        dateSelected = findViewById(R.id.displayDate)
        minutesDisplay = findViewById(R.id.textMinutesView)
        datePicker.setOnClickListener {
            datePickerHandler()
        }
    }

    private fun datePickerHandler(){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{_, selectedYear, selectedMonth, selectedDayOfMonth ->
//                Toast.makeText(this, "$selectedDayOfMonth / ${selectedMonth + 1} / $selectedYear", Toast.LENGTH_LONG).show()
                val theDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                dateSelected?.text = theDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val sdfDate = sdf.parse(theDate)
                sdfDate?.let{
                    val selectedDateInMinutes = sdfDate.time / 60000

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    currentDate?.let{
                        val currentDateInMinutes = currentDate.time / 60000

                        val difference = currentDateInMinutes - selectedDateInMinutes

                        minutesDisplay?.text = difference.toString()
                    }


                }

            },
            year, month, day

        )
        dpd.datePicker.maxDate = System.currentTimeMillis()
        dpd.show()
//        Toast.makeText(this, "$day $month $year", Toast.LENGTH_LONG).show()

    }
}
package com.basic.ageinminutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var dateField: DatePicker
    private lateinit var submit : Button
    private lateinit var calcAgeView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "AIM"
        dateField = findViewById(R.id.dateField)
        submit = findViewById(R.id.submit)
        calcAgeView = findViewById(R.id.ageView)

        submit.setOnClickListener {
            val day: Int = dateField.dayOfMonth
            val month: Int = dateField.month
            val year: Int = dateField.year

            val setCalender = Calendar.getInstance()
            setCalender.set(year, month, day)

            val currentCalender = Calendar.getInstance()

            val seconds: Long = (currentCalender.timeInMillis - setCalender.timeInMillis) / 1000
            val minutes: Long = seconds / 60
            val hours: Long = minutes / 60
            val days: Long = hours / 24
            val months: Long = days / 30
            val years: Long = months / 12

            calcAgeView.text = "$seconds seconds, $minutes minutes, $hours hours, $days days, $months months, $years years"
        }
    }
}
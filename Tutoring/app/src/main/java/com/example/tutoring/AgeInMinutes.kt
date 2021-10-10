package com.example.tutoring

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import java.text.SimpleDateFormat
import java.util.*

class AgeInMinutes : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var tvCalculateMyName : TextView
    private lateinit var btSet : Button
    private lateinit var myDateButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_in_minutes)

        toolbar = findViewById(R.id.toolbar_age)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.title = "MyAge"
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        tvCalculateMyName = findViewById(R.id.tvCalculateMyName)
        btSet = findViewById(R.id.btSet)
        myDateButton = findViewById<Button>(R.id.btnDatePicker)

        if(intent.hasExtra(MainActivity.MY_NAME)){
            val myName = intent.getStringExtra(MainActivity.MY_NAME).toString()
            tvCalculateMyName.text = "Calculate $myName"
        }

        myDateButton.setOnClickListener { _ ->
            clickDatePicker()
        }

        btSet.setOnClickListener{ _ ->
            finish()
        }
    }

    private fun clickDatePicker(){
        val myCalendar = Calendar.getInstance()

        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        var myAge = 0

        val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{
                    _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    Toast.makeText(this@AgeInMinutes, "The chosen year is $year", Toast.LENGTH_LONG).show()

                    val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                    val myTvSelected = findViewById<TextView>(R.id.tvSelectedDate)
                    myTvSelected.text = selectedDate

                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                    val theDate = sdf.parse(selectedDate)

                    var selectedDateInMinutes = theDate!!.time / 60000

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    val currentDateInMinutes = currentDate!!.time / 60000

                    val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                    myAge = (differenceInMinutes / 525600).toInt()

                    val mIntent = Intent()
                    mIntent.putExtra(MainActivity.MY_AGE, myAge.toString())
                    setResult(Activity.RESULT_OK, mIntent)

                    val selectedTv = findViewById<TextView>(R.id.tvSelectedDateInMinutes)
                    selectedTv.text = differenceInMinutes.toString()
                }
                ,year
                ,month
                ,day)

        dpd.datePicker.maxDate = Date().time - 86400000
        dpd.show()
    }


}
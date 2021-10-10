package com.example.tutoring


import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvName : TextView
    private lateinit var etMyName : EditText
    private lateinit var tvMyName : TextView
    private lateinit var llMyAge : LinearLayout
    private lateinit var tvAge : TextView
    private lateinit var tvMyAge : TextView

    companion object{
        const val MY_NAME = "MY_NAME"
        const val MY_AGE = "MY_AGE"
        const val GET_MY_AGE = 1
    }

    var myAge : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvName = findViewById(R.id.tvName)
        etMyName = findViewById(R.id.etMyName)
        tvMyName = findViewById(R.id.tvMyName)
        llMyAge = findViewById(R.id.llMyAge)
        tvAge = findViewById(R.id.tvAge)
        tvMyAge = findViewById(R.id.tvMyAge)

        llMyAge.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == GET_MY_AGE){
                if(data != null){
                    myAge = data.getStringExtra(MY_AGE)
                    tvMyAge.text = myAge
                }
            }

            etMyName.visibility = View.GONE

            tvMyName.text = etMyName.text.toString()
            tvMyName.visibility = View.VISIBLE
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.llMyAge -> {
                val intent = Intent(this@MainActivity, AgeInMinutes::class.java)

                intent.putExtra(MY_NAME, etMyName.text.toString())
                startActivityForResult(intent, GET_MY_AGE)
            }
        }
    }


}
package com.example.tutoring


import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class ExerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        /**
         * findViewById<>()을 이용해서
         * date를 설정하기 위한 button을 불러오세요
         */

        // val myDateButton =
        findViewById<Button>(R.id.btnDatePicker).setOnClickListener { view ->
            clickDatePicker()
        }

        /**
         * setOnClickListener을 이용해서 myDateButton을 클릭할 때 달력을 호출할 수 있도록 설정해주세요
         */

        // myDateButton
    }

    private fun clickDatePicker(){
        // Calendar class를 이용해서 instance를 하나 만들어주세요.
        val myCalendar = Calendar.getInstance()

        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        /**
         * DatePickerDialog를 설정해주세요
         * DatePickerDialog(context, DatePickerDialog.OnDateSetListener{_, selectedYear, selectedMonth, selectedDayOfMonth -> body}, year, month, day)
         * => context: 어디에 dialog를 위치실 것인지
         * => DatePickerDialog.OnDateSetListener: 달력에서 버튼을 눌러 setting 할 때 어떤 프로세스를 작동시킬 것인지
         * => year: 초기 년도 설정
         * => month: 초기 월 설정
         * => day: 초기 날짜 설정
         */

        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    _, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this@ExerciseActivity, "The chosen year is $year", Toast.LENGTH_LONG).show()

                /**
                 * selectedDate에 "day/month/year"의 형태로 string 값을 설정해주세요
                 */
                //val selectedDate = ""

                /**
                 * myTvSelected에 layout을 참고해서 Selected Date을 나타내는 TextView를 설정해주세요
                 */
                //val myTvSelected =

                // myTvSelected의 text에 selectedDate 값으로 넣어주세요
                //

                /**
                 * SimpleDateFormat(pattern, locale): 간단히 날짜를 Date type으로 바꿔주는 역할
                 * pattern: pattern을 통해 날짜를 어떤 식으로 표현할 것인지 정해주는 것
                 *          ex) "yyyy/MM/dd" 라고 설정했으면 yyyy는 년도, MM은 월, dd는 날짜를 의미한다.
                 * locale: 무슨 기준으로 날짜를 정해줄 것인지 ex) Locale.KOREA는 한국 중심으로 날짜를 설정한다.
                 *
                 * SimpleDateFormat instance를 만들어주세요
                 * 단 형태는 "날짜/월/년도", 한국 기준으로 설정해주세요
                 */

                //val sdf =

                /**
                 * SimpleDateFormat에 있는 parse 기능으로 selected를 Date type으로 바꿔주세요
                 *
                 */

                // val theDate = sdf

                var selectedDateInMinutes = theDate!!.time / 60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateInMinutes = currentDate!!.time / 60000

                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                /**
                 * selectedTv에 layout을 참고해서 Selected Date in Minutes을 나타내는 TextView를 설정해주세요
                 */
                // val selectedInMinutesTv =
                /**
                 * selectedInMinutesTv에 minutes로 나타낸 나이를 넣어주세요
                 */

                // selectedInMinutesTv.text =
            }
            ,year
            ,month
            ,day)

        dpd.datePicker.maxDate = Date().time - 86400000
        dpd.show()
    }
}
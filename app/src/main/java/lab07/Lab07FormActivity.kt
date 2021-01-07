package lab07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.lab01.R
import kotlin.math.log

class Lab07FormActivity : AppCompatActivity() {
    private lateinit var etName : EditText
    private lateinit var etAddress : EditText
    private lateinit var etMobile : EditText
    private lateinit var rdoGender: RadioGroup
    private lateinit var btnSubmit : Button

    private val students = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab07_form)

        etName = findViewById(R.id.etName)
        etAddress = findViewById(R.id.etAddress)
        etMobile = findViewById(R.id.etMobile)
        rdoGender = findViewById(R.id.rdoGroup)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            addStudents()
        }
    }
    private fun addStudents(){
        val name = etName.text.toString()
        val address = etAddress.text.toString()
        val mobileNumber = etMobile.text.toString()
        val checkedID = rdoGender.checkedRadioButtonId
        val checkedRadioButton: RadioButton = findViewById(checkedID)
        val sex = checkedRadioButton.text.toString()

        students.add(Student(name, address, mobileNumber, sex ))

        val intent = Intent(this, Lab07OutputActivity::class.java)
        intent.putExtra("students", students)
        startActivity(intent)
        Log.d("Lab07OutputActivity", "${students.toString()}")
    }
}
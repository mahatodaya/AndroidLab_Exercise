package lab07

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.lab01.R

class Lab07OutputActivity : AppCompatActivity() {

    private lateinit var lvStudent : ListView
    private lateinit var tvName : TextView
    private lateinit var tvAddress : TextView
    private lateinit var tvGender : TextView
    private lateinit var tvMobileNumber : TextView
    private lateinit var btnStudent: Button
    private var students = arrayListOf<Student>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab07__output)

        lvStudent = findViewById(R.id.lvStudent)
        tvName = findViewById(R.id.tvName)
        tvAddress = findViewById(R.id.tvAddress)
        tvGender = findViewById(R.id.tvGender)
        tvMobileNumber = findViewById(R.id.tvMobileNumber)
        btnStudent = findViewById(R.id.btnAddStudent)

        btnStudent.setOnClickListener {
            val intent = Intent(this, Lab07FormActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val studentName = mutableListOf<String>()
            if (resultCode == Activity.RESULT_OK) {
                val student = data?.getParcelableExtra<Student>("students")
                if (student != null) {
                    students.add(student)
                }

                for (student in students) {
                    student.name?.let { studentName.add(it) }
                    Log.d("printed",studentName.toString())
                }
                lvStudent.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentName)
                lvStudent.setOnItemClickListener { parent, view, position, id ->
                    val name = parent.getItemAtPosition(position).toString()
                    studentDetails(name)
                }
            }
        }
    }
    private fun studentDetails(name : String) {
        for (student in students) {
            if (student.name == name) {
                tvName.text = "Name : $name"
                tvAddress.text = "Address : ${student.address}"
                tvMobileNumber.text = "Number : ${student.number}"
                tvGender.text = "Gender : ${student.gender}"
            }
        }
    }
}
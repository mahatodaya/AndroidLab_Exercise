package lab08

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.lab01.R

class Lab08FormActivity : AppCompatActivity() {
    private lateinit var etName : EditText
    private lateinit var etAddress: EditText
    private lateinit var etMobile : EditText
    private lateinit var rdoGender: RadioGroup
    private val students = arrayListOf<StudentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab08_form)

        etName = findViewById(R.id.etName8f)
        etAddress = findViewById(R.id.etAddress8f)
        etMobile = findViewById(R.id.etMobile8f)
        rdoGender = findViewById(R.id.rdoGroup8f)


        addStudent()
    }
    private fun addStudent(){
        val name = etName.text.toString()
        val address = etAddress.text.toString()
        val mobile = etMobile.text.toString()
        val checkID = rdoGender.checkedRadioButtonId
        val checkRB: RadioButton = findViewById(checkID)
        val sex = checkRB.text.toString()

        students.add(StudentModel(name, address))

        val intent = Intent(this, Lab08RecyclerViewActivity::class.java)
        intent.putExtra("students", students)
        startActivity(intent)
    }
}
package lab04

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.lab01.R
import java.util.*

class Formlab4Activity : AppCompatActivity() {
    private val department = arrayOf("Software Developer", "IT Manager", "Web Developer", "Database Administrator", "Network Administrator")

    private lateinit var etEmployeeName : EditText
    private lateinit var spDepartment : Spinner
    private lateinit var etAddress : EditText
    private lateinit var etDate : EditText
    private lateinit var btnSubmit : Button

    private lateinit var llOutput : LinearLayout
    private lateinit var tvOName : TextView
    private lateinit var tvODepartment : TextView
    private lateinit var tvOAddress : TextView
    private lateinit var tvODate : TextView

    var d = ""
    var e = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form2)

        etEmployeeName = findViewById(R.id.etEmpName)
        spDepartment = findViewById(R.id.spDepart)
        etAddress = findViewById(R.id.etAddress)
        etDate = findViewById(R.id.etDate)
        btnSubmit = findViewById(R.id.btnSubmit)

        llOutput = findViewById(R.id.llOutput)
        tvOName = findViewById(R.id.tvOname)
        tvODepartment = findViewById(R.id.tvOdepartment)
        tvOAddress = findViewById(R.id.tvOaddress)
        tvODate = findViewById(R.id.tvOdate)

        btnSubmit.setOnClickListener{
            llOutput.visibility =View.VISIBLE
            var name = etEmployeeName.text.toString()
            var address = etAddress.text.toString()
            tvOName.text = "Name: $name"
            tvODepartment.text = "Department Name: $d"
            tvOAddress.text = "Address: $address"
            tvODate.text = "Join Date: $e"
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, department)

        spDepartment.adapter = adapter
        spDepartment.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                d = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        etDate.setOnClickListener { loadDate() }
    }

    private fun loadDate(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                var g = "$year-${monthOfYear+1}-$dayOfMonth"
                etDate.setText(g)
                e = g
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }
}
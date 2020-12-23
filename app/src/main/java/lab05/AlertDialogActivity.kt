package lab05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.lab01.R

class AlertDialogActivity : AppCompatActivity() {
    private lateinit var etFullName: EditText
    private lateinit var etEmail: EditText
    private lateinit var rdoGroup: RadioGroup
    private lateinit var rdoStudent: RadioButton
    private lateinit var rdoStaff: RadioButton
    private lateinit var llStudent: LinearLayout
    private lateinit var batchSpinner: Spinner
    private lateinit var etStudentID: EditText
    private lateinit var llStaff: LinearLayout
    private lateinit var departmentSpinner: Spinner
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var llCustomAlertDialog: AlertDialog

    var FullName = ""
    var Email = ""
    var StudentID = ""
    var Password = ""
    var ConfirmPassword = ""
    var BatchSpinner = ""
    var DepartmentSpinner = ""

    private var isStudent = false

    private val batch = arrayOf("24A", "24B", "25A", "25B", "26A")
    private val department = arrayOf("Academic", "Admission", "Technical", "Exam", "Program")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        etFullName = findViewById(R.id.etFullName)
        etEmail = findViewById(R.id.etEmail)
        rdoGroup = findViewById(R.id.rdoStudent_StaffGroup)
        rdoStudent = findViewById(R.id.rdoStudent)
        rdoStaff = findViewById(R.id.rdoStaff)
        llStudent = findViewById(R.id.llStudent)
        batchSpinner = findViewById(R.id.batchSpinner)
        etStudentID = findViewById(R.id.etStudentID)
        llStaff = findViewById(R.id.llStaff)
        departmentSpinner = findViewById(R.id.departmentSpinner)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)

        callAdapter()
        rdoSelection()
        retrievesValues()

        btnRegister.setOnClickListener() {
            retrievesValues()
            alertDialog()
        }
    }

    private fun alertDialog() {

        val view = layoutInflater.inflate(R.layout.custom_alert_dialog, null)
        llCustomAlertDialog = AlertDialog.Builder(this)
                .setView(view)
                .setTitle("Information about staff or student").create()
        val btnCancel: Button = view.findViewById(R.id.btnCancel)
        val tvFullName: TextView = view.findViewById(R.id.tvFullName)
        val tvEmail: TextView = view.findViewById(R.id.tvEmail)
        val tvPassword: TextView = view.findViewById(R.id.tvPassword)
        val tvIsStudent: TextView = view.findViewById(R.id.tvIsStudent)
        val tvID: TextView = view.findViewById(R.id.tvStudentID)
        val tvBatch: TextView = view.findViewById(R.id.tvBatch)

        btnCancel.setOnClickListener() {
            llCustomAlertDialog.dismiss()
        }
        tvFullName.text = "Name : $FullName "
        tvEmail.text = "Email : $Email "
        tvPassword.text = "Password : $Password "
        if (isStudent) {
            tvIsStudent.text = "Is A Student"
            val id = etStudentID.text.toString()
            tvID.text = "ID: $StudentID"
            tvBatch.text = "Batch: $BatchSpinner"
        } else {
            tvIsStudent.text = "Is A Staff"
            tvBatch.visibility = View.GONE
            tvID.text = "Department: $DepartmentSpinner"
        }
        llCustomAlertDialog.show()
    }

    private fun callAdapter() {
        val batchAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, batch)
        batchSpinner.adapter = batchAdapter

        batchSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val batchSpinner = parent?.getItemAtPosition(position).toString()
                BatchSpinner = batchSpinner
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val departmentAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, department)
        departmentSpinner.adapter = departmentAdapter

        departmentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val departmentSpinner = parent?.getItemAtPosition(position).toString()
                DepartmentSpinner = departmentSpinner
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    private fun rdoSelection() {
        rdoStudent.setOnClickListener {
            isStudent = true
            llStudent.visibility = View.VISIBLE
            llStaff.visibility = View.GONE
        }

        rdoStaff.setOnClickListener {
            isStudent = false
            llStaff.visibility = View.VISIBLE
            llStudent.visibility = View.GONE
        }
    }

    private fun retrievesValues() {
        var fn = etFullName.text.toString()
        etFullName.setText(fn)
        FullName = fn
        var email = etEmail.text.toString()
        etEmail.setText(email)
        Email = email
        var studentID = etStudentID.text.toString()
        etStudentID.setText(studentID)
        StudentID = studentID
        var password = etPassword.text.toString()
        etPassword.setText(password)
        Password = password
        var confirmPassword = etConfirmPassword.text.toString()
        etConfirmPassword.setText(confirmPassword)
        ConfirmPassword = confirmPassword
    }
}
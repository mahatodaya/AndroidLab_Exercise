package lab05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.lab01.R

class AlertDialogActivity : AppCompatActivity() {
    private lateinit var etFullName : EditText
    private lateinit var etEmail : EditText
    private lateinit var rdoGroup : RadioGroup
    private lateinit var rdoStudent : RadioButton
    private lateinit var rdoStaff : RadioButton
    private lateinit var llStudent: LinearLayout
    private lateinit var batchSpinner: Spinner
    private lateinit var etStudentID: EditText
    private lateinit var llStaff: LinearLayout
    private lateinit var departmentSpinner: Spinner
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnRegister: Button


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
    }
}
package lab07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.lab01.R

class Lab07FormActivity : AppCompatActivity() {
    private lateinit var etName : EditText
    private lateinit var etAddress : EditText
    private lateinit var etMobile : EditText
    private lateinit var rdoGender: RadioGroup
    private lateinit var rdoMale : RadioButton
    private lateinit var rdoFemale : RadioButton
    private lateinit var btnSubmit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab07_form)

        etName = findViewById(R.id.etName)
        etAddress = findViewById(R.id.etAddress)
        etMobile = findViewById(R.id.etMobile)
        rdoGender = findViewById(R.id.rdoGroup)
        rdoMale = findViewById(R.id.rdoMale)
        rdoFemale = findViewById(R.id.rdoFemale)
        btnSubmit = findViewById(R.id.btnSubmit)
    }
}
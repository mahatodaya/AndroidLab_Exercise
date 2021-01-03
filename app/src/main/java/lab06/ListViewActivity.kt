package lab06

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.lab01.R

class ListViewActivity : AppCompatActivity() {
    private lateinit var etName : EditText
    private lateinit var etAddress : EditText
    private lateinit var etMobile : EditText
    private lateinit var rdoGender: RadioGroup
    private lateinit var rdoMale : RadioButton
    private lateinit var rdoFemale : RadioButton
    private lateinit var btnSubmit : Button

    val persons = arrayListOf<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        etName = findViewById(R.id.etName)
        etAddress = findViewById(R.id.etAddress)
        etMobile = findViewById(R.id.etMobile)
        rdoGender = findViewById(R.id.rdoGroup)
        rdoMale = findViewById(R.id.rdoMale)
        rdoFemale = findViewById(R.id.rdoFemale)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener{
            retrieveValues()
        }

    }

    private fun retrieveValues(){
        val name = etName.text.toString()
        val address = etAddress.text.toString()
        val mobile = etMobile.text.toString()
        val checkID = rdoGender.checkedRadioButtonId
        val checkRB: RadioButton = findViewById(checkID)
        val gender = checkRB.text.toString()

        persons.add(
            Person(
                name,
                address,
                mobile,
                gender
            )
        )

        Intent(this, OutputActivity::class.java).also {
            it.putExtra("persons", persons)
            startActivity(it)
        }
    }
}
package lab07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab07__output)

        lvStudent = findViewById(R.id.lvStudent)
        tvName = findViewById(R.id.tvName)
        tvAddress = findViewById(R.id.tvAddress)
        tvGender = findViewById(R.id.tvGender)
        tvMobileNumber = findViewById(R.id.tvMobileNumber)
        btnStudent = findViewById(R.id.btnAddStudent)
    }
}
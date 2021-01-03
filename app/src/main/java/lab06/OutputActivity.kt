package lab06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import com.example.lab01.R

class OutputActivity : AppCompatActivity() {
    private lateinit var lvPerson : ListView
    private lateinit var tvName : TextView
    private lateinit var tvAddress : TextView
    private lateinit var tvGender : TextView
    private lateinit var tvMobile : TextView

    private var persons = arrayListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        lvPerson = findViewById(R.id.lvPerson)
        tvName = findViewById(R.id.tvName)
        tvAddress = findViewById(R.id.tvAddress)
        tvGender = findViewById(R.id.tvGender)
        tvMobile = findViewById(R.id.tvMobile)
    }
}
package lab06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
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


        val intent = intent
        val personNames = mutableListOf<String>()
        if (intent != null) {
            persons = intent.getSerializableExtra("persons") as ArrayList<Person>
            for (person in persons) {
                Log.d("ShowActivity", person.Name)
                personNames.add(person.Name)
            }

            lvPerson.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                personNames
            )

            lvPerson.setOnItemClickListener { parent, view, position, id ->
                val name = parent.getItemAtPosition(position).toString()
                personDetails(name)
            }
        }
    }
    private fun personDetails(name : String) {
        for (person in persons) {
            if (person.Name == name) {
                tvName.text = "Name : $name"
                tvAddress.text = "Address : ${person.Address}"
                tvGender.text = "Gender : ${person.Gender}"
                tvMobile.text = "Mobile : ${person.Mobile}"

            }
        }
    }
}
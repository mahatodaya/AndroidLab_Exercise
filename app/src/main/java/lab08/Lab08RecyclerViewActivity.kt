package lab08

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab01.R

class Lab08RecyclerViewActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var btnAdd : Button
    private var lstStudent = ArrayList<StudentModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab08_recycler_view)

        recyclerView = findViewById(R.id.recyclerView)
        btnAdd = findViewById(R.id.btnStudentAdd8)
        loadStudent()

        val adapter = StudentAdapter(lstStudent, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnAdd.setOnClickListener {
            val intent = Intent(this, Lab08FormActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadStudent(){
        lstStudent.add(StudentModel(
            "Ramesh Thapa", "Baneshwor"
        ))
    }
}
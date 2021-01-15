package lab08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab01.R

class Lab08RecyclerViewActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private var lstStudent = ArrayList<StudentModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab08_recycler_view)

        recyclerView = findViewById(R.id.recyclerView)
        loadStudent()

        val adapter = StudentAdapter(lstStudent, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun loadStudent(){
        lstStudent.add(StudentModel("https://www.ucl.ac.uk/news/sites/news/files/styles/large_image/public/jasmina_panovska-griffiths_crop.jpg?itok=Da5xMrTh",
            "Ramesh Thapa", "Baneshwor"
        ))
    }
}
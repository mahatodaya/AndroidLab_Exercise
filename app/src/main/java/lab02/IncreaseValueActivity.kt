package lab02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.lab01.R

class IncreaseValueActivity : AppCompatActivity() {
    private lateinit var tvValue: TextView
    private lateinit var btnValue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_increase_value)

        tvValue = findViewById(R.id.tvValue)
        btnValue = findViewById(R.id.btnValue)

        btnValue.setOnClickListener(){
            var numValue = tvValue.text.toString().toInt()
            numValue+= 1
            tvValue.text = numValue.toString()
        }

    }
}
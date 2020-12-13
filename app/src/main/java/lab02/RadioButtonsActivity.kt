package lab02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import com.example.lab01.R

class RadioButtonsActivity : AppCompatActivity() {

    private lateinit var rdoMale : RadioButton
    private lateinit var rdoFemale : RadioButton
    private lateinit var tvView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_buttons)

        rdoMale = findViewById(R.id.rdoMale)
        rdoFemale = findViewById(R.id.rdoFemale)
        tvView = findViewById(R.id.tvView)

        rdoMale.setOnClickListener(){
            setText("Male")
        }
        rdoFemale.setOnClickListener(){
            setText("Female")
        }
    }
    private fun setText(sex : String){
        tvView.text = sex
    }
}
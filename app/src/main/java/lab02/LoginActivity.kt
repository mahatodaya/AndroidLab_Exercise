package lab02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.lab01.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btnlogin : Button = findViewById(R.id.btnLogin)
        var etUser : EditText = findViewById(R.id.etUsername)
        var etPsw : EditText = findViewById(R.id.etPassword)

        btnlogin.setOnClickListener(){
            when {
                etUser.text.toString() == "admin" && etPsw.text.toString() == "admin" -> {
                    Toast.makeText(this, "You are Logged in", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "You are not Logged in", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
package com.example.miprimerlayout

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val textView : TextView = findViewById(R.id.title_profile)
        val email : EditText = findViewById(R.id.email_user)
        val password : EditText = findViewById(R.id.password_user)

        val radioGroup = findViewById<RadioGroup>(R.id.rg_gender)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rb_male -> {
                    Log.d("RADIO", "Masculino seleccionado")
                }
                R.id.rb_female -> {
                    Log.d("RADIO", "Femenino seleccionado")
                }
                R.id.rb_other -> {
                    Log.d("RADIO", "Otro seleccionado")
                }
            }
        }

        val btnLogin : TextView = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener {
            val emailValue = email.text.toString()
            val passwordValue = password.text.toString()

            if (!(emailValue.isNotEmpty() && passwordValue.isNotEmpty())) {
                Toast.makeText(this, "Por favor complete los campos", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
        }
            }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
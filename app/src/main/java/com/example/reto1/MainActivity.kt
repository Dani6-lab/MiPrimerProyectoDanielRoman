package com.example.reto1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cbAndroid = findViewById<CheckBox>(R.id.cbAndroid)
        val cbReact = findViewById<CheckBox>(R.id.cbReact)
        val cbFlutter = findViewById<CheckBox>(R.id.cbFlutter)

        val listenerCheck = CompoundButton.OnCheckedChangeListener { boton, marcado ->
            val estado = if (marcado) "marcado" else "desmarcado"
            Toast.makeText(this, "${boton.text} $estado", Toast.LENGTH_SHORT).show()
        }

        cbAndroid.setOnCheckedChangeListener(listenerCheck)
        cbReact.setOnCheckedChangeListener(listenerCheck)
        cbFlutter.setOnCheckedChangeListener(listenerCheck)
    }
}
package com.example.reto1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
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

        val spinnerCurso = findViewById<Spinner>(R.id.spinnerCurso)

        spinnerCurso.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val curso = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, "Curso: $curso", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}
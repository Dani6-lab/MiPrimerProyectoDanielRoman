package com.example.reto1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
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
        val etName = findViewById<EditText>(R.id.etName)
        val rgModalidad = findViewById<RadioGroup>(R.id.rgModalidad)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar2)

        btnGuardar.setOnClickListener {
            val nombre = etName.text.toString()

            val tecnologias = mutableListOf<String>()
            if (cbAndroid.isChecked) tecnologias.add("Android")
            if (cbReact.isChecked) tecnologias.add("React")
            if (cbFlutter.isChecked) tecnologias.add("Flutter")

            val modalidad = findViewById<RadioButton>(rgModalidad.checkedRadioButtonId).text
            val curso = spinnerCurso.selectedItem.toString()

            tvResultado.text = "Resumen: $nombre\nTecnologías: ${tecnologias.joinToString()}\nModalidad: $modalidad\nCurso: $curso"
        }
    }
}
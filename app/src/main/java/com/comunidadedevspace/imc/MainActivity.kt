package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_peso);
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_altura);
        val edtButton = findViewById<Button>(R.id.btn_calcular);

        edtButton.setOnClickListener {
            val peso: Float = edtWeight.text.toString().toFloat();
            val altura: Float = edtHeight.text.toString().toFloat();

            val imc = peso / (altura*altura);


            println("CLIQUE -> " + imc);
        }

    }
}
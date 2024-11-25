package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_peso);
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_altura);
        val edtButton = findViewById<Button>(R.id.btn_calcular);

        edtButton.setOnClickListener {
            val pesoStr: String = edtWeight.text.toString();
            val alturaStr: String = edtHeight.text.toString();

            if(pesoStr.isNotEmpty() && alturaStr.isNotEmpty()) {
                val peso: Float = pesoStr.toFloat();
                val altura: Float = alturaStr.toFloat();

                val imc = peso / (altura*altura);

                val intent = Intent(this, ResultActivity::class.java);
                intent.putExtra(KEY_RESULT_IMC, imc)
                startActivity(intent);

            }
            else {
                Snackbar.make(edtWeight, "Preencha todos os campos!", Snackbar.LENGTH_SHORT).show();
            }

        }

    }
}
package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {
            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
                Snackbar.make(it, "Preencha todos os campos", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            try {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                if (peso <= 0 || altura <= 0) {
                    Snackbar.make(it, "O peso e a altura devem ser maiores que zero", Snackbar.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, resultado)
                startActivity(intent)
            } catch (e: NumberFormatException) {
                Snackbar.make(it, "Por favor, insira valores numéricos válidos", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}

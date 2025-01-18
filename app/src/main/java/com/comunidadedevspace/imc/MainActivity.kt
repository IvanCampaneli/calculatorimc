package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        btnCalcular.setOnClickListener {

            val pesotStr = edtPeso.text.toString()
            val alturatStr = edtAltura.text.toString()

            if (pesotStr.isEmpty()) {
                edtPeso.error = "Preencha o peso"
                return@setOnClickListener
            }

            if (alturatStr.isEmpty()) {
                edtAltura.error = "Preencha a altura"
                return@setOnClickListener
            }

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            val altura: Float = alturaStr.toFloat()
            val peso: Float = pesoStr.toFloat()

            val alturaFinal: Float = altura * altura
            val result: Float = peso / alturaFinal

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("imc_result", result)
            startActivity(intent)
        }
    }
}
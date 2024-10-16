package com.example.testestlrf

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var buttonAbrirDetalhes : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonAbrirDetalhes = findViewById(R.id.button_detalhar)

        buttonAbrirDetalhes.setOnClickListener {
            // Definir a tela que será aberta
            val intent = Intent(this, DetalhesActivity::class.java)

            // Passar dados entre as telas
            intent.putExtra("filme", "The Witcher")
            intent.putExtra("classificacao", 5)
            intent.putExtra("avaliacoes", 9.2)

            // Passar Objeto entre as telas (Serializable)
            val filme2 = Filme(
                nome = "King Kong",
                classificacao = 7,
                avaliacoes = 4.2
            )
            intent.putExtra("filme2", filme2)

            // Passar Objeto entre as telas (Parcelize)
            val filme3 = FilmeParcelize (
                nome = "Sonic 3",
                classificacao = 8,
                avaliacoes = 8.7
            )
            intent.putExtra("filme3", filme3)


            // Iniciar nova tela
            startActivity(intent)
        }
    }
}
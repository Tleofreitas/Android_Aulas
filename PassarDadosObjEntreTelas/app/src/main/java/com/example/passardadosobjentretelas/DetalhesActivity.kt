package com.example.passardadosobjentretelas

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    lateinit var buttonVoltar : Button
    lateinit var textFilme : TextView
    lateinit var textFilmeObjSerializable : TextView
    lateinit var textFilmeObjParcelize : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonVoltar = findViewById(R.id.button_voltar)
        textFilme = findViewById(R.id.textFilme)
        textFilmeObjSerializable = findViewById(R.id.textFilmeObjSerializable)
        textFilmeObjParcelize = findViewById(R.id.textFilmeObjKotlinParcelize)

        // Pegar DADOS passados
        // Todos os parâmetros
        val bundle = intent.extras

        // val filmes = bundle?.getString("filme")
        if(bundle != null) {
            val filme = bundle.getString("filme")
            val classificacao = bundle.getInt("classificacao")
            val avaliacoes = bundle.getDouble("avaliacoes")

            val resultado = "Filme: $filme - Class. $classificacao - Avaliações: $avaliacoes"

            textFilme.text = resultado
        }

        // Pegar OBJETO passado Serializable
        val bundleObj = intent.extras
        if(bundleObj != null) {
            // SDK mais antigos
            val filme2 = if(Build.VERSION.SDK_INT >= 33){
                bundleObj.getSerializable("filme2", Filme::class.java)
            // SDK atuais
            } else {
                bundleObj.getSerializable("filme2") as Filme
            }
            textFilmeObjSerializable.text = "Filme: ${filme2?.nome} - Class. ${filme2?.classificacao} - Avaliações: ${filme2?.avaliacoes}"
        }

        // Pegar OBJETO passado Kotlin Parcelize
        val bundleObjP = intent.extras
        if(bundleObjP != null) {
            // SDK mais antigos
            val filme3 = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                bundleObjP.getParcelable("filme3", FilmeParcelize::class.java)

            // SDK atuais
            } else {
                bundleObjP.getParcelable("filme3")
            }
            textFilmeObjParcelize.text = "Filme: ${filme3?.nome} - Class. ${filme3?.classificacao} - Avaliações: ${filme3?.avaliacoes}"
        }

        buttonVoltar.setOnClickListener {
            finish()
        }
    }
}
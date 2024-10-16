package com.example.fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragments.fragments.ChamadasFragment
import com.example.fragments.fragments.ConversasFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnConversas : Button
    private lateinit var btnChamadas : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnConversas = findViewById(R.id.btn_conversas)
        btnChamadas = findViewById(R.id.btn_chamadas)

        btnConversas.setOnClickListener {
            /* // Modo Comum
            // beginTransaction() = Iniciar Transação
            val fragmentManager = supportFragmentManager.beginTransaction()

            // Realizar alterações necessárias
            fragmentManager.add(R.id.fragment_conteudo, ConversasFragment())

            // Salvar as alterações
            fragmentManager.commit()
             */

            // Modo Simplificado
            supportFragmentManager.beginTransaction()
                // add adiciona um sobre o outro, por isso usa-se replace
                // .add(R.id.fragment_conteudo, ConversasFragment())
                .replace(R.id.fragment_conteudo, ConversasFragment())
                .commit()

        }

        btnChamadas.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_conteudo, ChamadasFragment())
                .commit()
        }

        // Remover um Fragment exemplo:
        /* val conversasFragment = ConversasFragment()
        btnChamadas.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .remove(conversasFragment)
                .commit()
        } */
    }
}
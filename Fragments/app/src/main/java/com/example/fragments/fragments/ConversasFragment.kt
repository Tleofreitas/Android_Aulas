package com.example.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragments.R

// Criação Simples
// Para criar Fragments simples, que não exigem muitas alterações, pode-se utilizar:
// class ConversasFragment : Fragment (R.layout.fragment_conversas) {
class ConversasFragment : Fragment () {

    private lateinit var btnExecutar : Button
    private lateinit var textNome : TextView
    private lateinit var editNome : EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        // Caso use Criação Simples
        return inflater.inflate(
            R.layout.fragment_conversas,
            container,
            false
        )*/
        val view = inflater.inflate(
            R.layout.fragment_conversas,
            container,
            false
        )

        // Nos fragments, para acessar os id's, precisa utilizar a view
        // Processamento de visualização
        btnExecutar = view.findViewById(R.id.btn_executar)
        editNome = view.findViewById(R.id.edit_nome)
        textNome = view.findViewById(R.id.textNome)

        btnExecutar.setOnClickListener {
            textNome.text = editNome.text.toString()
        }

        return  view
    }
}
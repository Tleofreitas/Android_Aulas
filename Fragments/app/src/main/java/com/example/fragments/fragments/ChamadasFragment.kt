package com.example.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragments.R

class ChamadasFragment : Fragment() {
    private var categoria: String? = null
    private var usuario: String? = null

    private lateinit var textCategoria : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoria = arguments?.getString("categoria")
        usuario = arguments?.getString("usuario")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_chamada,
            container,
            false
        )

        textCategoria = view.findViewById(R.id.text_categoria)
        textCategoria.text = "$categoria \n$usuario"

        return view
    }
}
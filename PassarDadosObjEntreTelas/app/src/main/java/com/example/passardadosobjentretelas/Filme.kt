package com.example.passardadosobjentretelas

import java.io.Serializable

data class Filme(
    val nome: String,
    val classificacao: Int,
    val avaliacoes: Double
) : Serializable

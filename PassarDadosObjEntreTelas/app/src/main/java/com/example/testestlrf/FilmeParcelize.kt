package com.example.testestlrf

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilmeParcelize(
    val nome: String,
    val classificacao: Int,
    val avaliacoes: Double
) : Parcelable

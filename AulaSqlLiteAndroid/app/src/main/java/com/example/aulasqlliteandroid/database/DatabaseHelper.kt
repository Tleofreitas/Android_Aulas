package com.example.aulasqlliteandroid.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context : Context) : SQLiteOpenHelper(
    // 1) Contexto
    context,
    // 2) Nome do banco de dados
    "loja.db",
    // 3) Cursor Factory
    null,
    // 4) Versão do banco de dados
    1

    // context, "loja.db", null, 1
) {
    // Executado uma única vez, na instalação do app
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    // Será executado sempre que houver uma nova versão
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}
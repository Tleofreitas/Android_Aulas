package com.example.aulasqlliteandroid.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

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

        Log.i("info_db", "Executou onCreate")

        val sql = "create TABLE if not EXISTS produtos (" +
                "id_produto integer not null PRIMARY KEY AUTOINCREMENT," +
                "titulo varchar(100)," +
                "descricao text" +
                ");"

        try {
            db?.execSQL( sql )
            Log.i("info_db", "Sucesso ao criar a tabela")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Erro ao criar a tabela")
        }
    }

    // Será executado sempre que houver uma nova versão
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        Log.i("info_db", "Executou onUpgrade")
    }
}
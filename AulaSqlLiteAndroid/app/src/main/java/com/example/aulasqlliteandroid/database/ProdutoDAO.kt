package com.example.aulasqlliteandroid.database

import android.content.Context
import android.util.Log
import com.example.aulasqlliteandroid.model.Produto

class ProdutoDAO(context: Context): IProdutoDAO {

    val escrita = DatabaseHelper(context).writableDatabase
    val leitura = DatabaseHelper(context).readableDatabase

    override fun salvar(produto: Produto): Boolean {
        val sql = "INSERT INTO ${DatabaseHelper.TABELA_PRODUTOS} VALUES (null, '', 'Descrição do notebook Acer');"

        try{
            escrita.execSQL( sql )
            Log.i("info_db", "Sucesso ao Inserir")
        }catch (e: Exception) {
            Log.i("info_db", "Erro ao Inserir")
        }
    }

    override fun atualizar(produto: Produto): Boolean {
        TODO("Not yet implemented")
    }

    override fun remover(idProduto: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Produto> {
        TODO("Not yet implemented")
    }
}
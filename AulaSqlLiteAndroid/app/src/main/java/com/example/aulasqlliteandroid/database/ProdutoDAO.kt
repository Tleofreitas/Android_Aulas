package com.example.aulasqlliteandroid.database

import android.content.Context
import android.util.Log
import com.example.aulasqlliteandroid.model.Produto

class ProdutoDAO(context: Context): IProdutoDAO {

    val escrita = DatabaseHelper(context).writableDatabase
    val leitura = DatabaseHelper(context).readableDatabase

    override fun salvar(produto: Produto): Boolean {
        val titulo = produto.titulo
        val sql = "INSERT INTO ${DatabaseHelper.TABELA_PRODUTOS} VALUES (null, '$titulo', 'Descrição do notebook Acer');"

        try{
            escrita.execSQL( sql )
            Log.i("info_db", "Sucesso ao Inserir")
        }catch (e: Exception) {
            Log.i("info_db", "Erro ao Inserir")
            return false
        }
        return true
    }

    override fun atualizar(produto: Produto): Boolean {
        val titulo = produto.titulo
        val idProduto = produto.idProduto

        // id de forma manual por enquanto
        val sql = "UPDATE ${DatabaseHelper.TABELA_PRODUTOS} SET ${DatabaseHelper.TITULO} = '$titulo' " +
                "WHERE ${DatabaseHelper.ID_PRODUTO} =$idProduto;"

        try{
            escrita.execSQL( sql )
            Log.i("info_db", "Sucesso ao Atualizar")
        }catch (e: Exception) {
            Log.i("info_db", "Erro ao Atualizar")
            return false
        }
        return true
    }

    override fun remover(idProduto: Int): Boolean {
        val sql = "DELETE FROM ${DatabaseHelper.TABELA_PRODUTOS} WHERE ${DatabaseHelper.ID_PRODUTO} = $idProduto;"

        try{
            escrita.execSQL( sql )
            Log.i("info_db", "Sucesso ao Remover")
        }catch (e: Exception) {
            Log.i("info_db", "Erro ao Remover")
            return false
        }
        return true
    }

    override fun listar(): List<Produto> {
        val listaDeProdutos = mutableListOf<Produto>()

        val sql = "SELECT * FROM ${DatabaseHelper.TABELA_PRODUTOS};"
        val cursor = leitura.rawQuery(sql, null)

        val indiceId = cursor.getColumnIndex("${DatabaseHelper.ID_PRODUTO}")
        val indiceTitulo = cursor.getColumnIndex("${DatabaseHelper.TITULO}")
        val indiceDescricao = cursor.getColumnIndex("${DatabaseHelper.DESCRICAO}")

        while (cursor.moveToNext()) {
            //Log.i("info_db", "posição: ${cursor.position}")

            val idProduto = cursor.getInt(indiceId)
            val titulo = cursor.getString(indiceTitulo)
            val descricao = cursor.getString(indiceDescricao)

            // Log.i("info_db", "id: $idProduto - $titulo")

            listaDeProdutos.add(
                Produto(idProduto, titulo, descricao)
            )
        }
        return listaDeProdutos
    }
}
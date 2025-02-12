package com.example.aulasqlliteandroid.database

import com.example.aulasqlliteandroid.model.Produto

interface IProdutoDAO {
    fun salvar(produto: Produto) : Boolean
    fun atualizar(produto: Produto) : Boolean
    fun remover(idProduto: Int) : Boolean
    fun listar() : List<Produto>
}
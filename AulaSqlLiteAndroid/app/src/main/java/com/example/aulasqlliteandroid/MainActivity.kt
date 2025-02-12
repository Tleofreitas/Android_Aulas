package com.example.aulasqlliteandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aulasqlliteandroid.database.DatabaseHelper
import com.example.aulasqlliteandroid.database.ProdutoDAO
import com.example.aulasqlliteandroid.databinding.ActivityMainBinding
import com.example.aulasqlliteandroid.model.Produto

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val bancoDados by lazy {
        DatabaseHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)

        with(binding){
            btnSalvar.setOnClickListener { salvar() }
            btnListar.setOnClickListener { listar() }
            btnAtualizar.setOnClickListener { atualizar() }
            btnRemover.setOnClickListener { remover() }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun salvar() {
        val titulo = binding.editProduto.text.toString()
        val produtoDAO = ProdutoDAO(this)
        val produto = Produto(
            -1, "$titulo", "descrição.."
        )
        produtoDAO.salvar(produto)
    }

    private fun atualizar() {
        val titulo = binding.editProduto.text.toString()
        val produtoDAO = ProdutoDAO(this)
        val produto = Produto(
            7, "$titulo", "descrição.."
        )
        produtoDAO.atualizar(produto)
    }

    private fun remover() {
        val produtoDAO = ProdutoDAO(this)
        produtoDAO.remover(7)

    }

    private fun listar() {
        val produtoDAO = ProdutoDAO(this)
        val listaProdutos = produtoDAO.listar()

        if(listaProdutos.isNotEmpty()) {
            listaProdutos.forEach{ produto ->
                Log.i("info_db", "${produto.idProduto} - ${produto.titulo}")
            }
        }
    }
}
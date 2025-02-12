package com.example.aulasqlliteandroid

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
        if(produtoDAO.salvar(produto)) {
            Toast.makeText(this, "Sucesso ao cadastrar produto", Toast.LENGTH_SHORT).show()
            binding.editProduto.setText("")
        } else {
            Toast.makeText(this, "ERRO ao cadastrar produto", Toast.LENGTH_SHORT).show()
        }
    }

    private fun atualizar() {
        val titulo = binding.editProduto.text.toString()
        val produtoDAO = ProdutoDAO(this)
        val produto = Produto(
            1, "$titulo", "descrição.."
        )
        produtoDAO.atualizar(produto)
    }

    private fun remover() {
        val produtoDAO = ProdutoDAO(this)
        produtoDAO.remover(1)

    }

    private fun listar() {
        val produtoDAO = ProdutoDAO(this)
        val listaProdutos = produtoDAO.listar()

        var texto = "";
        if(listaProdutos.isNotEmpty()) {
            listaProdutos.forEach{ produto ->
                texto += "${produto.idProduto} - ${produto.titulo}\n"
                Log.i("info_db", "${produto.idProduto} - ${produto.titulo}")
            }
            binding.textResultado.text = texto
        } else {
            binding.textResultado.text = "Nenhum item cadastrado"
        }
    }
}
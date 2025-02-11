package com.example.aulasqlliteandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aulasqlliteandroid.database.DatabaseHelper
import com.example.aulasqlliteandroid.databinding.ActivityMainBinding

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
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun listar() {
        val sql = "SELECT * FROM ${DatabaseHelper.TABELA_PRODUTOS};"
        val cursor = bancoDados.readableDatabase.rawQuery(sql, null)

        val indiceId = cursor.getColumnIndex("${DatabaseHelper.ID_PRODUTO}")
        val indiceTitulo = cursor.getColumnIndex("${DatabaseHelper.TITULO}")
        val indiceDescricao = cursor.getColumnIndex("${DatabaseHelper.DESCRICAO}")

        while (cursor.moveToNext()) {
            //Log.i("info_db", "posição: ${cursor.position}")

            val idProduto = cursor.getInt(indiceId)
            val titulo = cursor.getString(indiceTitulo)
            val descricao = cursor.getString(indiceDescricao)

            Log.i("info_db", "id: $idProduto - $titulo")
        }
    }

    private fun salvar() {

        val titulo = binding.editProduto.text.toString()
        val sql = "INSERT INTO ${DatabaseHelper.TABELA_PRODUTOS} VALUES (null, '$titulo', 'Descrição do notebook Acer');"

        try{
            bancoDados.writableDatabase.execSQL( sql )
            Log.i("info_db", "Sucesso ao Inserir")
        }catch (e: Exception) {
            Log.i("info_db", "Erro ao Inserir")
        }
    }
}
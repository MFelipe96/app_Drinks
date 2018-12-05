package com.mfelipe.app_drinks

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_lista_bebidas.*

class ListaDrinksActivity : AppCompatActivity() {


    val listaDrinks: MutableList<Drinks> = mutableListOf()

    private val mOnNavigationItemSelectedListener = OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val paginaInicial = Intent(this, ListaDrinksActivity::class.java)
                startActivity(paginaInicial)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_perfil -> {
                val telaPerfil = Intent(this, MainActivity::class.java)
                startActivity(telaPerfil)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favoritos -> {
                //message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_bebidas)

        //CarregaLista()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun CarregaLista() {

        // obrigatorios para termos um recycler view
        val adapter = DrinkAdapter(this, listaDrinks)
        val layoutManager = LinearLayoutManager(this)

        adapter.ConfiguraClique {

            val exibirDetalhes = Intent(this, ExibeDetalhesActivity::class.java)
            this.startActivity(exibirDetalhes)
        }

        rvListaBebidas.adapter = adapter
        rvListaBebidas.layoutManager = layoutManager
    }
}
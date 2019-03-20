package br.com.felipea.android.appestagio.activity

import android.app.Activity
import android.app.IntentService
import android.app.Person
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import br.com.felipea.android.appestagio.R
import java.lang.Exception

class ListPersonActivity : Activity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_person)
        // adicionando pessoas testes e a nova pessoa colocada
        val p1: br.com.felipea.android.appestagio.model.Person =
            br.com.felipea.android.appestagio.model.Person("Felipe", "xxx", "UFC", "Fortaleza", "CE", "Brasil")

        val listPessoas = arrayListOf<br.com.felipea.android.appestagio.model.Person>(p1,p1)
        //testando as funçoes de lista
        listPessoas += (p1)
        //capturando os dados da pessoa digitada na intent anterior, utilizando Parcelable
        val novaPessoa = intent.getParcelableExtra<br.com.felipea.android.appestagio.model.Person>("NewPerson")
        if (novaPessoa != null) {
            listPessoas.add(novaPessoa)
        }

        //Comandos do recyclerView
        viewManager = LinearLayoutManager(this) as RecyclerView.LayoutManager
        viewAdapter = MyAdapter.MyAdapter(
            listPessoas.toTypedArray()
        )
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview_id).apply {
            // usando esse codigo abaixo, ele melhora a questão de desempenho da recyclerView em si, porem não
            // sue tamanho
            setHasFixedSize(true)


            layoutManager = viewManager

            //Especificando o adapter
            adapter = viewAdapter

        }
    }

}

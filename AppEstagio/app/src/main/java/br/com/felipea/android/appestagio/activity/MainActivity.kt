package br.com.felipea.android.appestagio.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import br.com.felipea.android.appestagio.R

class MainActivity : AppCompatActivity() {
    lateinit var btn_listPerson: Button
    lateinit var btn_location: Button
    lateinit var btn_adcPerson: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_listPerson = findViewById(R.id.btn_listPerson)
        btn_adcPerson = findViewById(R.id.btn_adcPerson)
        btn_location = findViewById(R.id.btn_location)

        //Abrindo a lista de pessoas
        btn_listPerson.setOnClickListener {
            val intent = Intent(this, ListPersonActivity::class.java)
            startActivity(intent)
        }
        //abrindo a localização do gps/network do usuario
        btn_location.setOnClickListener {
            val intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }
        //abrindo a tela de ADC
        btn_adcPerson.setOnClickListener {
            val intent = Intent(this, NewPersonActivity::class.java)
            startActivity(intent)

        }
    }
}

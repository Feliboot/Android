package br.com.felipea.android.appestagio.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.felipea.android.appestagio.R
import br.com.felipea.android.appestagio.model.Person
import kotlinx.android.synthetic.main.person_cell.*
import java.io.Serializable
import java.util.regex.Pattern

class NewPersonActivity : AppCompatActivity() {
    lateinit var nome: EditText
    lateinit var email: EditText
    lateinit var empresa: EditText
    lateinit var cidade: EditText
    lateinit var estado: EditText
    lateinit var pais: EditText
    lateinit var btn_add: Button
    lateinit var btn_cancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_person)
        nome = findViewById(R.id.nome_campo_id)
        email = findViewById(R.id.email_campo_id)
        empresa = findViewById(R.id.empresa_campo_id)
        cidade = findViewById(R.id.cidade_campo_id)
        estado = findViewById(R.id.estado_campo_id)
        pais = findViewById(R.id.pais_campo_id)
        btn_add = findViewById(R.id.btn_add_ok)
        btn_cancel = findViewById(R.id.btn_add_cancel)
        //Ação de adicionar uma pessoa e fazendo verificação dos campos (validação)
        btn_add.setOnClickListener {
            if (VerificaCampos()) {
                val p1 = Person(
                    nome.text.toString(),
                    email.text.toString(),
                    empresa.text.toString(),
                    cidade.text.toString(),
                    estado.text.toString(),
                    pais.text.toString()
                )
                val intent = Intent(this, ListPersonActivity::class.java)
                intent.putExtra("NewPerson",p1)
                Toast.makeText(this, "Pessoa adicionada!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
        btn_cancel.setOnClickListener { finish() }
    }

    fun VerificaCampos(): Boolean {
        if (!nome.text.isBlank()) {
            if (Pattern.compile("\\d").matcher(nome.text).find()) {
//                verificando se ha digitos
                Toast.makeText(this, "Há digitos no campo nome!", Toast.LENGTH_LONG).show()
                return false
            }

        }

        if (empresa.text.length > 200) {
            Toast.makeText(this, "Numero excedido de caracteres para campo empresa!", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}

package fernandosousa.com.br.lmsapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        // acessar parametros da intnet
        // intent é um atributo herdado de Activity
        val args = intent.extras
        // recuperar o parâmetro do tipo String
        val nome = args.getString("nome")

        // recuperar parâmetro simplificado
        val numero = intent.getIntExtra("nome",0)

        //Toast.makeText(context, "Parâmetro: $nome", Toast.LENGTH_LONG).show()
        //Toast.makeText(context, "Numero: $numero", Toast.LENGTH_LONG).show()

        val mensagem = findViewById<TextView>(R.id.mensagemInicial)
        mensagem.text = "Bem vindo $nome"

        val botaoSair = findViewById<Button>(R.id.botaoSair)
        botaoSair.setOnClickListener {cliqueSair()}

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Disciplinas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    fun cliqueSair() {
        val returnIntent = Intent();
        returnIntent.putExtra("result","Saída do BrewerApp");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == R.id.action_buscar){
            Toast.makeText(this,"Clicou buscar: ", Toast.LENGTH_SHORT).show()
        }else if (id == R.id.action_atualizar){
            Toast.makeText(this,"Clicou para atualizar: ", Toast.LENGTH_SHORT).show()
        }else if (id == R.id.action_config){
            Toast.makeText(this,"Clicou no Configurações: ", Toast.LENGTH_SHORT).show()
        }
        else if (id == android.R.id.home){
            Toast.makeText(this,"Clicou no voltar: ", Toast.LENGTH_SHORT).show()
            cliqueSair()
        }
        return super.onOptionsItemSelected(item)
    }
}

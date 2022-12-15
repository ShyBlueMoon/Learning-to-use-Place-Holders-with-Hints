package luana.estudos.treinandoplaceholders

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import luana.estudos.treinandoplaceholders.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val nomeDoApp:String = "AUPLog"
        private const val activity:String = "MainActivity::"
        const val NOME_USUARIO:String = "luana.estudos.treinandoplaceholders"
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.i(nomeDoApp, "$activity onCreate iniciado")

        configurarEnviarNomeListener()
    }

    private fun configurarEnviarNomeListener(){
        binding.btnSalvar.setOnClickListener() {
           //Aqui você coloca as funções dos outros botões, como botão Salvar, Cancelar, Edit etc
            salvarNome()
        }
    }

    private fun salvarNome() {
        binding.apply {
            //Capturar nome(string) no EditText View
            val nomeDoUsuario = digiteNomeView.text.toString()

            //AQUI VALIDAMOS O INPUT
            //Se o que tá la na View pra digitar o nome está vazio, acontece isso
            if (nomeDoUsuario.isEmpty()) {
                digiteNomeView.error = getString(R.string.err_sem_nome)
            } else {
                digiteNomeView.error = null
            }

            //Aqui, se o não estiver vazio ele manda a string para a outra activity
            if (nomeDoUsuario.isNotEmpty()) {
                val intentEnviarNome = Intent(this@MainActivity, FraseEspecialActivity::class.java)
                intentEnviarNome.putExtra(NOME_USUARIO, nomeDoUsuario)
                startActivity(intentEnviarNome)
            }

        }
    }
}
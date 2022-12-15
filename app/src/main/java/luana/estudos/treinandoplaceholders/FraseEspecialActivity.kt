package luana.estudos.treinandoplaceholders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import luana.estudos.treinandoplaceholders.databinding.ActivityFraseEspecialBinding
import luana.estudos.treinandoplaceholders.databinding.ActivityMainBinding
import luana.estudos.treinandoplaceholders.MainActivity.Companion.NOME_USUARIO

class FraseEspecialActivity : AppCompatActivity() {

    companion object {
        private const val nomeDoApp:String = "AUPLog"
        private const val activity:String = "FraseEspecialActivity::"
    }

    private lateinit var binding: ActivityFraseEspecialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFraseEspecialBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.i(nomeDoApp, "$activity onCreate iniciado")

        //Capturar a intent e extrair a string do Nome
        val mostrarNome = intent.getStringExtra(NOME_USUARIO)

        //Capturar o Layout da TextView e põe o string como seu texto
        val textView =findViewById<TextView>(R.id.nomeView).apply {
            text = mostrarNome
        }
    }

}
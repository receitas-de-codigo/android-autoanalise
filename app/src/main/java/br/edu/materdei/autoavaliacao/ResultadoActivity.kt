package br.edu.materdei.autoavaliacao

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.edu.materdei.autoavaliacao.http.PerguntaLista
import br.edu.materdei.autoavaliacao.model.Resposta
import kotlinx.android.synthetic.main.activity_resultado.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        doAsync {

            val preferences = getSharedPreferences("app", 0);

            val resposta = Resposta(
                preferences.getString("nome", "Não Informado"),
                PerguntaLista.list
            )

            val resultado = PerguntaLista.gravarPerguntas(this@ResultadoActivity, resposta)

            uiThread {
                var str = "Resultado: \n";

                resultado.forEach { it ->
                    str += it.valor.toString()
                    str += " -> "
                    str += it.caracteristica
                    str += "\n"
                }

                editTextResultado.text.append( str )
            }
        }
    }
}

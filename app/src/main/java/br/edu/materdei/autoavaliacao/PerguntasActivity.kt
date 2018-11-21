package br.edu.materdei.autoavaliacao


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.edu.materdei.autoavaliacao.http.PerguntaLista
import kotlinx.android.synthetic.main.activity_perguntas.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class PerguntasActivity : AppCompatActivity() {

    var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas)


        doAsync {
            PerguntaLista.atualizarLista(this@PerguntasActivity)

            uiThread {
                pergunta.text = PerguntaLista.list.get( index ).pergunta
            }
        }

        btnNunca.setOnClickListener {
            responder(1)
        }

        btnRarasVezes.setOnClickListener {
            responder(2)
        }

        btnAlgumasVezes.setOnClickListener {
            responder(3)
        }

        btnUsualmente.setOnClickListener {
            responder(4)
        }

        btnSempre.setOnClickListener {
            responder(5)
        }
    }

    private fun responder(pontos: Int) {
        PerguntaLista.list.get(index).pontos = pontos

        index++

        if ( index >= PerguntaLista.list.size ) {
            gravarNoServidor()
        } else {
            pergunta.text = index.toString() + "\n" + PerguntaLista.list.get( index ).pergunta
        }
    }

    private fun gravarNoServidor() {
        startActivity( Intent(this, ResultadoActivity::class.java) )
    }

}

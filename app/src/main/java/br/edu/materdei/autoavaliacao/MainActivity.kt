package br.edu.materdei.autoavaliacao

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonIniciar.setOnClickListener {

            val preferences = getSharedPreferences("app", 0);
            val edit = preferences.edit();
            edit.putString("nome", nome.text.toString())
            edit.apply()

            val intent =
                Intent(this, PerguntasActivity::class.java)

            startActivity( intent )
        }
    }
}

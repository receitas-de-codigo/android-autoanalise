package br.edu.materdei.autoavaliacao.http;

import android.app.Activity;
import br.edu.materdei.autoavaliacao.BuildConfig;
import br.edu.materdei.autoavaliacao.PerguntasActivity;
import br.edu.materdei.autoavaliacao.model.Pergunta;
import br.edu.materdei.autoavaliacao.model.Resposta;
import br.edu.materdei.autoavaliacao.model.Resultado;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerguntaLista {

    public static List<Pergunta> list = new ArrayList<>();


    public static void atualizarLista(PerguntasActivity perguntasActivity) {
        ResponseEntity<Pergunta[]> forEntity = RestTemplateSingleton
                .getInstance(perguntasActivity)
                .getRestTemplate()
                .getForEntity(BuildConfig.SERVIDOR + "/pergunta", Pergunta[].class);

        PerguntaLista.list = Arrays.asList( forEntity.getBody() );
    }

    public static Resultado[] gravarPerguntas(@NotNull Activity activity, Resposta resposta) {
        return RestTemplateSingleton.getInstance(activity)
                .getRestTemplate()
                .postForEntity(BuildConfig.SERVIDOR + "/resposta", resposta, Resultado[].class).getBody();
    }


}

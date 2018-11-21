package br.edu.materdei.autoavaliacao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resposta {

    private Long id;

    private String nome;

    private List<Pergunta> lsPerguntas;

    public Resposta() {

    }

    public Resposta(String nome, List<Pergunta> lsPerguntas) {
        this.nome = nome;
        this.lsPerguntas = lsPerguntas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pergunta> getLsPerguntas() {
        return lsPerguntas;
    }

    public String getNome() {
        return nome;
    }

    public void setLsPerguntas(List<Pergunta> lsPerguntas) {
        this.lsPerguntas = lsPerguntas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
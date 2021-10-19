package br.com.cwi.reset.alandill.domain;

import java.time.LocalDate;

public class Estudio {
    Integer id;
    String nome;
    String descaricao;
    LocalDate dataCriacao;
    StatusAtividade statusAtividade;

    public Estudio(Integer id, String nome, String descaricao, LocalDate dataCriacao, StatusAtividade statusAtividade) {
        this.id = id;
        this.nome = nome;
        this.descaricao = descaricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
    }
}

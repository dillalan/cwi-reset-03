package br.com.cwi.reset.alandill.request;

import br.com.cwi.reset.alandill.domain.StatusAtividade;

import java.time.LocalDate;

public class EstudioRequest{
    Integer id;
    String nome;
    String descricao;
    LocalDate dataCriacao;
    StatusAtividade statusAtividade;

    public EstudioRequest(Integer id, String nome, String descricao, LocalDate dataCriacao, StatusAtividade statusAtividade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
    }

    public Integer getId() {
        return id;
    }

    public void setId() {
        this.id = getId()+1;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public StatusAtividade getStatusAtividade() {
        return statusAtividade;
    }
}

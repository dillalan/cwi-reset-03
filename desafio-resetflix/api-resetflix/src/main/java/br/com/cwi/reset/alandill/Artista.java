package br.com.cwi.reset.alandill;

import java.time.LocalDate;

public class Artista {
    private Integer id = 0;
    private String nome;
    private LocalDate dataNascimento;
    private Integer anoInicioAtividade;

    public Artista(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.id = setId();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }

    public Integer setId() {
        return this.id += 1;
    }
}

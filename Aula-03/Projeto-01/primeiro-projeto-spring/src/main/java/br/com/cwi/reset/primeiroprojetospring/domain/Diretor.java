package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Diretor extends Pessoa{

    private Integer filmesDirigidos;

    public Diretor(String nome, LocalDate dataNascimento, Integer filmesDirigidos, Genero genero) {
        super(nome, dataNascimento, genero);

        this.filmesDirigidos = filmesDirigidos;
    }

    public Integer getFilmesDirigidos() {
        return filmesDirigidos;
    }

    public void setFilmesDirigidos(Integer filmesDirigidos) {
        this.filmesDirigidos = filmesDirigidos;
    }
}

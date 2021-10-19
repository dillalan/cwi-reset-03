package br.com.cwi.reset.alandill.domain;

import br.com.cwi.reset.alandill.domain.Artista;

import java.time.LocalDate;

public class Diretor extends Artista {

    public Diretor(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        super(nome, dataNascimento, anoInicioAtividade);
    }

}

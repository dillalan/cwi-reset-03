package br.com.cwi.reset.alandill;

import java.time.LocalDate;

public class AtorEmAtividade extends Artista {
    private Integer id=0;

    public AtorEmAtividade(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        super(nome, dataNascimento, anoInicioAtividade);
        this.id = setId();
    }


}

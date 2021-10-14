package br.com.cwi.reset.alandill;

import java.time.LocalDate;

public class AtorEmAtividade extends Artista {
    private Integer incremento = 1;

    public AtorEmAtividade(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        super(nome, dataNascimento, anoInicioAtividade);
        setId(getIncremento());
        setIncremento();
    }

    public Integer getIncremento() {
        return incremento;
    }

    public void setIncremento() {
        this.incremento += 1;
    }
}

package br.com.cwi.reset.alandill;

import java.time.LocalDate;

public class Ator extends Artista {

    private StatusCarreira statusCarreira;


    public Ator(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        super(nome, dataNascimento, anoInicioAtividade);
        this.statusCarreira = statusCarreira;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

}

package br.com.cwi.reset.alandill.request;

import br.com.cwi.reset.alandill.domain.Ator;
import br.com.cwi.reset.alandill.domain.StatusCarreira;

import java.time.LocalDate;

public class AtorRequest extends Ator {

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade){
        super(nome, dataNascimento, statusCarreira, anoInicioAtividade);
    }

}

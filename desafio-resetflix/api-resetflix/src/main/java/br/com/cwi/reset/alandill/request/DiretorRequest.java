package br.com.cwi.reset.alandill.request;

import br.com.cwi.reset.alandill.domain.Diretor;

import java.time.LocalDate;

public class DiretorRequest extends Diretor {

    public DiretorRequest(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        super(nome, dataNascimento, anoInicioAtividade);
    }
}

package br.com.cwi.reset.alandill;

import java.time.LocalDate;

public class DiretorRequest extends Diretor {

    public DiretorRequest(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        super(nome, dataNascimento, anoInicioAtividade);
    }
    //TODO Campo filtroNome é opcional, quando informado deve filtrar por qualquer match na sequência do nome.


}

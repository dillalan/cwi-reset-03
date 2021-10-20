package br.com.cwi.reset.alandill.request;

import br.com.cwi.reset.alandill.domain.Estudio;
import br.com.cwi.reset.alandill.domain.StatusAtividade;

import java.time.LocalDate;

public class EstudioRequest extends Estudio {

    public EstudioRequest(String nome, String descricao, LocalDate dataCriacao, StatusAtividade statusAtividade) {
        super(nome, descricao, dataCriacao, statusAtividade);
    }
}

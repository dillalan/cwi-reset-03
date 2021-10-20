package br.com.cwi.reset.alandill.domain;

public enum StatusAtividade {
    EM_ATIVIDADE("Em atividade"),
    ENCERRADO("Encerrado");

    private String status;

    StatusAtividade(String status) {
        this.status = status;
    }
}

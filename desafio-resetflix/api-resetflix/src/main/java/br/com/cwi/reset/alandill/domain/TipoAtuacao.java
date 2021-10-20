package br.com.cwi.reset.alandill.domain;

public enum TipoAtuacao {
    PRINCIPAL("Principal"),
    COADJUVANTE("Coadjuvante");

    private String papel;

    TipoAtuacao(String papel) {
        this.papel = papel;
    }
}

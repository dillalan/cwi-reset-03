package br.com.cwi.reset.alandill.domain;

public enum StatusCarreira {
    EM_ATIVIDADE("Em atividade"),
    APOSENTADO("Aposentado");

    private String status;

    StatusCarreira(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

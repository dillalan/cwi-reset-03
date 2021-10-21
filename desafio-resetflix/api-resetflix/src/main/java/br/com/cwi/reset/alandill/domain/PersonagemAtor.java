package br.com.cwi.reset.alandill.domain;

public class PersonagemAtor {
    Integer id;
    Ator ator;
    String nomePersonagem;
    String descricaoPersonagem;
    TipoAtuacao tipoAtuacao;

    public PersonagemAtor(Ator ator, String nomePersonagem, String descricaoPersonagem,
                          TipoAtuacao tipoAtuacao) {
        this.ator = ator;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public Integer getId() {
        return id;
    }

    public Ator getAtor() {
        return ator;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }
}

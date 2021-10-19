package br.com.cwi.reset.alandill.domain;

public class PersonagemAtor {
    Integer id;
    Ator ator;
    String nomePersonagem;
    String descricaoPersonagem;
    TipoAtuacao tipoAtuacao;

    public PersonagemAtor(Integer id, Ator ator, String nomePersonagem, String descricaoPersonagem,
                          TipoAtuacao tipoAtuacao) {
        this.id = id;
        this.ator = ator;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }
}

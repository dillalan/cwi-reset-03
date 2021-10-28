package br.com.cwi.reset.alandill.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Genero> generos;
    @ManyToOne
    @JoinColumn(name = "id_estudio")
    private Estudio estudio;
    @ManyToOne
    @JoinColumn(name = "id_diretor")
    private Diretor diretor;
    @OneToMany
    @JoinColumn(name = "id_personagem_ator")
    private List<PersonagemAtor> personagens;
    private String resumo;


    public Filme(String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Diretor diretor,
                 List<PersonagemAtor> personagens, String resumo, Estudio estudio) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.diretor = diretor;
        this.personagens = personagens;
        this.resumo = resumo;
        this.estudio = estudio;
    }

    public Filme(){

    }

    public Integer getId() {
        return id;
    }

    public void setId() {
        this.id = getId()+1;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public List<PersonagemAtor> getPersonagens() {
        return personagens;
    }

    public String getResumo() {
        return resumo;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setCapaFilme(String capaFilme) {
        this.capaFilme = capaFilme;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public void setPersonagens(List<PersonagemAtor> personagens) {
        this.personagens = personagens;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
}

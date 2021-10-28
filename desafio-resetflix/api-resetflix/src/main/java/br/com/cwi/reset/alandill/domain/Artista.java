//package br.com.cwi.reset.alandill.domain;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "artista")
//@Inheritance(strategy = InheritanceType.JOINED)
//public class Artista {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String nome;
//    private LocalDate dataNascimento;
//    private Integer anoInicioAtividade;
//
//    public Artista(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
//        this.nome = nome;
//        this.dataNascimento = dataNascimento;
//        this.anoInicioAtividade = anoInicioAtividade;
//    }
//
//    public Artista(){
//
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public LocalDate getDataNascimento() {
//        return dataNascimento;
//    }
//
//    public Integer getAnoInicioAtividade() {
//        return anoInicioAtividade;
//    }
//
//}

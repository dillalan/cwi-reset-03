package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public void perfil() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + calcularIdade());
        System.out.println("Gênero: " + this.genero.getDescricao());
    }

    private Integer calcularIdade() {
        return LocalDate.now().compareTo(this.dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}

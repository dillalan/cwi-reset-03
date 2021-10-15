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

    public void perfil(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Idade: "+calcularIdade());
        System.out.println("Gênero: "+this.genero.getDescricao());
    }

    private Integer calcularIdade(){
        return LocalDate.now().compareTo(this.dataNascimento);
    }

    public String getNome() {
        return nome;
    }
}

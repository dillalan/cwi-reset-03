import java.time.LocalDate;

public class Diretor extends Pessoa{

    private Integer filmesDirigidos;

    public Diretor(String nome, LocalDate dataNascimento, Integer filmesDirigidos, Genero genero) {
        super(nome, dataNascimento, genero);

        this.filmesDirigidos = filmesDirigidos;
    }
}

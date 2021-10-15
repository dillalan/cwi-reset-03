import java.time.LocalDate;

public class Ator extends Pessoa{

    private Integer oscarPremiado;

    public Ator(String nome, LocalDate dataNascimento, Integer oscarPremiado, Genero genero) {
        super(nome, dataNascimento, genero);
        this.oscarPremiado = oscarPremiado;
    }
}

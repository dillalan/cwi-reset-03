public class Ator extends Pessoa{

    private Integer oscarPremiado;

    public Ator(String nome, Integer idade, Integer oscarPremiado, Genero genero) {
        super(nome, idade, genero);
        this.oscarPremiado = oscarPremiado;
    }
}

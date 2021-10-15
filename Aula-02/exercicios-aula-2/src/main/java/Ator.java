public class Ator {
    private String nome;
    private Integer idade;
    private Integer oscarPremiado;
    private Genero genero;

    public Ator(String nome, Integer idade, Integer oscarPremiado, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.oscarPremiado = oscarPremiado;
        this.genero = genero;
    }

    public void perfil(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Idade: "+this.idade);
        System.out.println("Gênero: "+this.genero.getDescricao());
    }



}

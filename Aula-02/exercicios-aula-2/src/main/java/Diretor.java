public class Diretor {
    private String nome;
    private Integer idade;
    private Integer filmesDirigidos;
    private Genero genero;

    public Diretor(String nome, Integer idade, Integer filmesDirigidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.filmesDirigidos = filmesDirigidos;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void perfil(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Idade: "+this.idade);
        System.out.println("Gênero: "+this.genero.getDescricao());
    }
}

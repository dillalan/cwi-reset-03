import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) throws AvaliacaoForaDoPadraoException {

        Diretor diretor1 = new Diretor("James Cameron", LocalDate.of(1954, Month.AUGUST, 16), 14, Genero.MASCULINO);
        Diretor diretor2 = new Diretor("Tim Burton", LocalDate.of(1958, Month.AUGUST, 25), 22, Genero.MASCULINO);

        Ator ator1 = new Ator("Jodie Foster", LocalDate.of(1962, Month.NOVEMBER, 19), 2, Genero.FEMININO);
        Ator ator2 = new Ator("Elliot Page", LocalDate.of(1987, Month.FEBRUARY, 21),0, Genero.NAO_BINARIO);

        Filme filme1 = new Filme(
                "Titanic",
                "É uma história de ficção do naufrágio real do RMS Titanic, estrelando Leonardo DiCaprio como " +
                        "Jack Dawson, e Kate Winslet como Rose DeWitt Bukater, membros de diferentes classes sociais que se " +
                        "apaixonam durante a fatídica viagem inaugural no navio saindo de Southampton para Nova York em " +
                        "15 de abril de 1912.",
                195,
                1997,
                4.5,
                diretor1);

        Filme filme2 = new Filme(
                "Edward Scissorhands",
                "Edward é a criação de um velho inventor, que veio a falecer antes de ter chance de terminar seu " +
                        "último trabalho, um jovem artificial de carne e osso, deixando-o sem nenhuma das mãos e " +
                        "completamente sozinho, na mansão sombria onde somente os dois moravam.",
                105,
                1990,
                4.8,
                diretor2);

        // Testa as classes criadas
        List<Diretor> diretores = new ArrayList<Diretor>();

        diretores.add(diretor1);
        diretores.add(diretor2);

        List<Ator> atores = new ArrayList<Ator>();

        atores.add(ator1);
        atores.add(ator2);

        List <Filme> filmes = new ArrayList<Filme>();
        filmes.add(filme1);
        filmes.add(filme2);

        for (Diretor diretor:
             diretores) {
            diretor.perfil();
        }

        for (Ator ator:
             atores) {
            ator.perfil();
        }

        for (Filme filme:
             filmes) {
            filme.reproduzir();
        }
    }
}

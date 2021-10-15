public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor1 = new Diretor("James Cameron", 67, 14);
        Diretor diretor2 = new Diretor("Tim Burton", 63, 22);

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

        filme1.reproduzir();
        filme2.reproduzir();

    }
}

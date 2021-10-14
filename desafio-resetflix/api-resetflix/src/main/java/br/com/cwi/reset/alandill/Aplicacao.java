package br.com.cwi.reset.alandill;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) throws NaoEncontradoException, SemCadastroException,
            NomeException, TemporalException, ObrigatorioException {
        FakeDatabase fakeDatabase = new FakeDatabase();

//        AtorService atorService = new AtorService(fakeDatabase);

        // Ator1: Will Smith
//        String nome = "Will Smith";
//        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
//        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
//        Integer anoInicioAtividade = 1986;
//
//        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);
//
//        atorService.criarAtor(atorRequest);

        //Ator2: Leonardo DiCaprio
//        String nome1 = "Leonardo DiCaprio";
//        LocalDate dataNascimento1 = LocalDate.of(1974, Month.NOVEMBER, 11);
//        StatusCarreira statusCarreira1 = StatusCarreira.EM_ATIVIDADE;
//        Integer anoInicioAtividade1 = 1990;

//        AtorRequest atorRequest1 = new AtorRequest(nome1, dataNascimento1, statusCarreira1, anoInicioAtividade1);
//
//        atorService.criarAtor(atorRequest1);

        // Testes
//        atorService.listarAtoresEmAtividade(); // Listar atores cadastrados
//
//        for (AtorEmAtividade atorEmAtividade:
//                atorService.listarAtoresEmAtividade("L")) { // Listar atores filtrados
//            System.out.println(atorEmAtividade.getId());
//        }
//
//        System.out.println(atorService.consultarAtores());
//
//
//
//        List<Ator> atores = fakeDatabase.recuperaAtores();
//
//        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
//        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());

        String nome2 = "Peter Jackson";
        LocalDate dataNascimento2 = LocalDate.of(1961, Month.OCTOBER, 31);
        Integer anoInicioAtividade2 = 1976;

        DiretorRequest diretorRequest = new DiretorRequest(nome2,dataNascimento2,anoInicioAtividade2);

        String nome3 = "Stanley Kubrick";
        LocalDate dataNascimento3 = LocalDate.of(1928, Month.JULY, 26);
        Integer anoInicioAtividade3 = 1953;

        DiretorRequest diretorRequest1 = new DiretorRequest(nome3,dataNascimento3,anoInicioAtividade3);

        DiretorService diretorService = new DiretorService(fakeDatabase);

        diretorService.cadastrarDiretor(diretorRequest);
        diretorService.cadastrarDiretor(diretorRequest1);

        System.out.println(diretorService.listarDiretores("stanley K"));

        System.out.println(diretorService.consultarDiretor(2));

    }
}

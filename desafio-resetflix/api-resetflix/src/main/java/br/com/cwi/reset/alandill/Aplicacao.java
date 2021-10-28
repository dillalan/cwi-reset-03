package br.com.cwi.reset.alandill;

import br.com.cwi.reset.alandill.domain.*;
import br.com.cwi.reset.alandill.exception.*;
import br.com.cwi.reset.alandill.request.*;
import br.com.cwi.reset.alandill.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Aplicacao {
    public static void main(String[] args) throws Exception {

        SpringApplication.run(Aplicacao.class, args);

//
//        // Request
//        AtorRequest atorRequest1 = new AtorRequest(
//                1,
//                "Al Pacino",
//                LocalDate.of(1940, Month.APRIL,25),
//                StatusCarreira.EM_ATIVIDADE,
//                1969);
//
//        DiretorRequest diretorRequest1 = new DiretorRequest(
//                1,
//                "Francis Ford Coppola",
//                LocalDate.of(1939,Month.APRIL,7),
//                1963);
//
//        EstudioRequest estudioRequest1 = new EstudioRequest(
//                1,
//                "Paramount Pictures",
//                "A Paramount foi um dos maiores e mais lucrativos estúdios de Hollywood nos anos 1920, 1940 e " +
//                        "1970. Modernamente, o estúdio procura reinventar a forma de fazer cinema, a fim de enfrentar " +
//                        "os desafios do século XXI, através do uso de novas tecnologias.",
//                LocalDate.of(1912,Month.MAY,8),
//                StatusAtividade.EM_ATIVIDADE);
//
//        PersonagemRequest personagemRequest1 = new PersonagemRequest(
//                atorRequest1.getId(),
//                "Michael Corleone",
//                "Michael, um herói de guerra retorna para casa e acaba tendo de gerir os negócios da família",
//                TipoAtuacao.PRINCIPAL);
//
//        List<Genero> generos1 = new ArrayList<>();
//        generos1.add(Genero.ACAO);
//        generos1.add(Genero.POLICIAL);
//
//        List<PersonagemRequest> personagens1 = new ArrayList<>();
//        personagens1.add(personagemRequest1);
//
//        FilmeRequest filmeRequest1 = new FilmeRequest(
//                "O Poderoso Chefão",
//                1972,
//                "Capa preta com título",
//                generos1,
//                diretorRequest1.getId(),
//                estudioRequest1.getId(),
//                "A saga da família Corleone em uma America em transformação",
//                personagens1);
//
//
//        // Service
//        AtorService atorService = new AtorService(FakeDatabase.getInstance());
//        DiretorService diretorService = new DiretorService(FakeDatabase.getInstance());
//        EstudioService estudioService = new EstudioService(FakeDatabase.getInstance());
//        PersonagemAtorService personagemAtorService = new PersonagemAtorService(FakeDatabase.getInstance());
//        FilmeService filmeService = new FilmeService(FakeDatabase.getInstance());
//
//        atorService.criarAtor(atorRequest1);
//        diretorService.cadastrarDiretor(diretorRequest1);
//        estudioService.criarEstudio(estudioRequest1);
//        personagemAtorService.criarPersonagem(personagemRequest1);
//        filmeService.criarFilme(filmeRequest1);

    }
}

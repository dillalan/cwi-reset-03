package br.com.cwi.reset.primeiroprojetospring.controller;


import br.com.cwi.reset.primeiroprojetospring.domain.AvaliacaoForaDoPadraoException;
import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @GetMapping
    public Filme retornaFilme() throws AvaliacaoForaDoPadraoException {
        Diretor diretor1 = new Diretor("James Cameron", LocalDate.of(1954, Month.AUGUST, 16), 14, Genero.MASCULINO);
        return new Filme("Titanic",
                "É uma história de ficção do naufrágio real do RMS Titanic, estrelando Leonardo DiCaprio como " +
                        "Jack Dawson, e Kate Winslet como Rose DeWitt Bukater, membros de diferentes classes sociais que se " +
                        "apaixonam durante a fatídica viagem inaugural no navio saindo de Southampton para Nova York em " +
                        "15 de abril de 1912.",
                195,
                1997,
                4.5,
                diretor1);
    }
}

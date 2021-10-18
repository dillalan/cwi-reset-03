package br.com.cwi.reset.primeiroprojetospring.controller;


import br.com.cwi.reset.primeiroprojetospring.domain.AvaliacaoForaDoPadraoException;
import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    private static List<Filme> filmes = new ArrayList<>();

    // Exercício 3
//    @GetMapping
//    public Filme retornaFilme() throws AvaliacaoForaDoPadraoException {
//        Diretor diretor1 = new Diretor("James Cameron", LocalDate.of(1954, Month.AUGUST, 16), 14, Genero.MASCULINO);
//        return new Filme("Titanic",
//                "É uma história de ficção do naufrágio real do RMS Titanic, estrelando Leonardo DiCaprio como " +
//                        "Jack Dawson, e Kate Winslet como Rose DeWitt Bukater, membros de diferentes classes sociais que se " +
//                        "apaixonam durante a fatídica viagem inaugural no navio saindo de Southampton para Nova York em " +
//                        "15 de abril de 1912.",
//                195,
//                1997,
//                4.5,
//                diretor1);
//    }

    // Exercício 4
    @PostMapping
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme) {
        for (Filme f :
                filmes) {
            if (f.getNome().equalsIgnoreCase(filme.getNome())) {
                return ResponseEntity.badRequest().build();
            }
        }
        filmes.add(filme);
        return ResponseEntity.ok(filme);
    }

    @GetMapping
    public List<Filme> listarFilmes() {
        return filmes;
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Object> consultarFilme(@PathVariable String nome) {
        for (Filme filme :
                filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return ResponseEntity.ok(filme);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Object> removerFilme(@PathVariable String nome) {
        if (buscarFilme(nome) == null) {
            return ResponseEntity.notFound().build();
        }
        filmes.remove(buscarFilme(nome));
        return ResponseEntity.ok(buscarFilme(nome));
    }

    @PutMapping
    public Filme atualizarFilme(@RequestBody Filme filme) {
        Filme filmeParaAtualizar = buscarFilme(filme.getNome());
        if (filmeParaAtualizar == null) {
            return null;
        }
        filmes.remove(filmeParaAtualizar);
        filmes.add(filme);
        return filme;
    }

    public Filme buscarFilme(String nome) {
        Filme resultado = null;
        for (Filme f : filmes) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                resultado = f;
                break;
            }
        }
        return resultado;
    }


}

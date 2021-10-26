package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.exception.ArtistaNaoEncontradoException;
import br.com.cwi.reset.projeto1.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @PostMapping
    public void criarAtor(@RequestBody Ator ator){
        atorService.criaAtor(ator);
    }

    @DeleteMapping("/{id}")
    public void apagarAtor(@PathVariable Integer id) throws ArtistaNaoEncontradoException {
        atorService.apagaAtor(id);
    }

    @GetMapping("/{nome}")
    public Ator buscaAtorPorNome(@PathVariable String nome) throws ArtistaNaoEncontradoException {
        return atorService.buscaAtorPorNome(nome);
    }

    @GetMapping
    public List<Ator> buscaAtorPorNumeroDeOscars(@PathParam("{numeroOscars}") Integer numeroOscars) throws ArtistaNaoEncontradoException {
        return atorService.buscaAtorPorNumeroDeOscars(numeroOscars);
    }

    @GetMapping("/atores")
    public List<Ator> listarAtores(){
        return atorService.listar();
    }
}

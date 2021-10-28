package br.com.cwi.reset.alandill.controller;

import br.com.cwi.reset.alandill.domain.Filme;
import br.com.cwi.reset.alandill.exception.NaoEncontradoException;
import br.com.cwi.reset.alandill.exception.NomeException;
import br.com.cwi.reset.alandill.exception.ObrigatorioException;
import br.com.cwi.reset.alandill.exception.SemCadastroException;
import br.com.cwi.reset.alandill.request.FilmeRequest;
import br.com.cwi.reset.alandill.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody FilmeRequest filmeRequest) throws ObrigatorioException, NaoEncontradoException, NomeException, SemCadastroException {
        filmeService.criarFilme(filmeRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Filme> consultarFilmes(@PathParam("{nomeFilme}") String nomeFilme,
                                       @PathParam("{nomeDiretor}") String nomeDiretor,
                                       @PathParam("{nomePersonagem}") String nomePersonagem,
                                       @PathParam("{nomeAtor}") String nomeAtor) throws NaoEncontradoException {

        return filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);

    }
}

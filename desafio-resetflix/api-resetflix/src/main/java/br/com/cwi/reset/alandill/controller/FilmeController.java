package br.com.cwi.reset.alandill.controller;

import br.com.cwi.reset.alandill.FakeDatabase;
import br.com.cwi.reset.alandill.exception.NaoEncontradoException;
import br.com.cwi.reset.alandill.exception.NomeException;
import br.com.cwi.reset.alandill.exception.ObrigatorioException;
import br.com.cwi.reset.alandill.request.FilmeRequest;
import br.com.cwi.reset.alandill.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private FilmeService filmeService;

    public FilmeController() {
        this.filmeService = new FilmeService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody FilmeRequest filmeRequest) throws ObrigatorioException, NaoEncontradoException, NomeException {
        filmeService.criarFilme(filmeRequest);
    }


}

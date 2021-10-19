package br.com.cwi.reset.alandill.controller;

import br.com.cwi.reset.alandill.FakeDatabase;
import br.com.cwi.reset.alandill.domain.Ator;
import br.com.cwi.reset.alandill.exception.NaoEncontradoException;
import br.com.cwi.reset.alandill.exception.NomeException;
import br.com.cwi.reset.alandill.exception.TemporalException;
import br.com.cwi.reset.alandill.request.AtorRequest;
import br.com.cwi.reset.alandill.service.AtorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/atores")
@RestController
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws TemporalException, NomeException {
        atorService.criarAtor(atorRequest);
    }

    @GetMapping
    public List<Ator> consultarAtores(){
        return FakeDatabase.getInstance().recuperaAtores();
    }
}

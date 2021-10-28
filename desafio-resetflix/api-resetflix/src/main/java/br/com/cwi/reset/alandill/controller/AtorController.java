package br.com.cwi.reset.alandill.controller;

import br.com.cwi.reset.alandill.domain.Ator;
import br.com.cwi.reset.alandill.exception.*;
import br.com.cwi.reset.alandill.request.AtorRequest;
import br.com.cwi.reset.alandill.response.AtorEmAtividade;
import br.com.cwi.reset.alandill.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/atores")
@RestController
public class AtorController {

    @Autowired
    private AtorService atorService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws TemporalException, NomeException, ObrigatorioException {
        atorService.criarAtor(atorRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/em_atividade")
    public List<AtorEmAtividade> consultarAtoresEmAtividade(@PathParam("{filtroNome}") String filtroNome) throws SemCadastroException, NaoEncontradoException {
        return atorService.listarAtoresEmAtividade(filtroNome);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Ator consultarAtor(@PathVariable Integer id) throws NaoEncontradoException, ObrigatorioException {
        return atorService.consultarAtor(id);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Ator> consultarAtores() throws SemCadastroException {
        return atorService.consultarAtores();
    }
}

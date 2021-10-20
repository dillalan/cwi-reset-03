package br.com.cwi.reset.alandill.controller;

import br.com.cwi.reset.alandill.FakeDatabase;
import br.com.cwi.reset.alandill.domain.Diretor;
import br.com.cwi.reset.alandill.exception.*;
import br.com.cwi.reset.alandill.request.DiretorRequest;
import br.com.cwi.reset.alandill.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/diretores")
@RestController
@Controller
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController(){
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws TemporalException, NomeException, ObrigatorioException {
        diretorService.cadastrarDiretor(diretorRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List <Diretor> listarDiretores(@PathParam("{filtroNome}") String filtroNome) throws NaoEncontradoException, SemCadastroException {
        return diretorService.listarDiretores(filtroNome);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Diretor consultarDiretor(@PathVariable Integer id) throws NaoEncontradoException, ObrigatorioException {
        return diretorService.consultarDiretor(id);
    }
}

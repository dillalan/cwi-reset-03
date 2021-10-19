package br.com.cwi.reset.alandill.controller;

import br.com.cwi.reset.alandill.FakeDatabase;
import br.com.cwi.reset.alandill.domain.Diretor;
import br.com.cwi.reset.alandill.exception.NaoEncontradoException;
import br.com.cwi.reset.alandill.exception.NomeException;
import br.com.cwi.reset.alandill.exception.SemCadastroException;
import br.com.cwi.reset.alandill.exception.TemporalException;
import br.com.cwi.reset.alandill.request.DiretorRequest;
import br.com.cwi.reset.alandill.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/diretores")
@RestController
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController(){
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void cadastrarDiretor(DiretorRequest diretorRequest) throws TemporalException, NomeException {
        diretorService.cadastrarDiretor(diretorRequest);
    }


    public List <Diretor> listarDiretores(String filtroNome) throws NaoEncontradoException, SemCadastroException {
        return diretorService.listarDiretores(filtroNome);
    }


}

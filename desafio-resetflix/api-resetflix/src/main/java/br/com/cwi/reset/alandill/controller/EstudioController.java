package br.com.cwi.reset.alandill.controller;

import br.com.cwi.reset.alandill.FakeDatabase;
import br.com.cwi.reset.alandill.domain.Estudio;
import br.com.cwi.reset.alandill.exception.*;
import br.com.cwi.reset.alandill.request.EstudioRequest;
import br.com.cwi.reset.alandill.service.EstudioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/estudios")
@RestController
public class EstudioController {
    private EstudioService estudioService;

    public EstudioController(){
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws TemporalException, ObrigatorioException, NomeException {
        this.estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estudio> consultarEstudios(@PathParam("{filtroNome}") String filtroNome) throws NaoEncontradoException, SemCadastroException {
        return this.estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Estudio consultarEstudio(@PathVariable Integer id) throws ObrigatorioException, NaoEncontradoException, SemCadastroException {
        return this.estudioService.consultarEstudio(id);
    }


}

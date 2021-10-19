package br.com.cwi.reset.alandill.controller;

import br.com.cwi.reset.alandill.FakeDatabase;
import br.com.cwi.reset.alandill.service.EstudioService;

public class EstudioController {
    private EstudioService estudioService;

    public EstudioController(){
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }
    // TODO
}

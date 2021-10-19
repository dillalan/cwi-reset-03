package br.com.cwi.reset.alandill.controller;

import br.com.cwi.reset.alandill.FakeDatabase;
import br.com.cwi.reset.alandill.service.DiretorService;

public class DiretorController {

    private DiretorService diretorService;

    public DiretorController(){
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    // TODO
}

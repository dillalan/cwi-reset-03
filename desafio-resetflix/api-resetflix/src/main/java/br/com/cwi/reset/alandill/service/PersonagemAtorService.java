package br.com.cwi.reset.alandill.service;

import br.com.cwi.reset.alandill.FakeDatabase;
import br.com.cwi.reset.alandill.domain.Ator;
import br.com.cwi.reset.alandill.domain.PersonagemAtor;
import br.com.cwi.reset.alandill.exception.NaoEncontradoException;
import br.com.cwi.reset.alandill.exception.ObrigatorioException;
import br.com.cwi.reset.alandill.request.PersonagemRequest;

import java.util.List;

public class PersonagemAtorService {

    private FakeDatabase fakeDatabase;
    private Integer id = 1;
    private AtorService atorService;


    public PersonagemAtorService(FakeDatabase fakeDatabase){
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    public void criarPersonagem(PersonagemRequest personagemRequest) throws NaoEncontradoException, ObrigatorioException {
        validaEntrada(personagemRequest);
        PersonagemAtor personagemAtor = new PersonagemAtor(atorService.consultarAtor(personagemRequest.getIdAtor()), personagemRequest.getNomePersonagem(), personagemRequest.getDescricaoPersonagem(), personagemRequest.getTipoAtuacao());
        this.fakeDatabase.persistePersonagem(personagemAtor);
    }

    private void validaEntrada(PersonagemRequest personagemRequest) throws ObrigatorioException, NaoEncontradoException {

        //Valida campos obrigatórios
        if (personagemRequest.getNomePersonagem() == null){
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {NomePersonagem}.");
        } else if (personagemRequest.getIdAtor() == null){
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {idAtor}.");
        } else if (personagemRequest.getDescricaoPersonagem()==null){
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {descricaoPersonagem}.");
        } else if (personagemRequest.getTipoAtuacao() == null){
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {tipoAtuacao}.");
        }

        //Valida existência de ator
        boolean flag = false;
        for (Ator ator:
             this.fakeDatabase.recuperaAtores()) {
            if (ator.getId()== personagemRequest.getIdAtor()){
                flag = true;
                break;
            }
        }
        if (!flag){
            throw new NaoEncontradoException("Nenhum ator encontrado com o parâmetro id={id}, favor verifique os parâmetros informados.");
        }

    }
}

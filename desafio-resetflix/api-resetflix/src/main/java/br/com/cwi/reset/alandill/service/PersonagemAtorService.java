package br.com.cwi.reset.alandill.service;

import br.com.cwi.reset.alandill.domain.Ator;
import br.com.cwi.reset.alandill.domain.PersonagemAtor;
import br.com.cwi.reset.alandill.exception.NaoEncontradoException;
import br.com.cwi.reset.alandill.exception.ObrigatorioException;
import br.com.cwi.reset.alandill.repository.PersonagemAtorRepository;
import br.com.cwi.reset.alandill.request.PersonagemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonagemAtorService {

    @Autowired
    private PersonagemAtorRepository personagemAtorRepository;
    @Autowired
    private AtorService atorService;

    public void criarPersonagem(PersonagemRequest personagemRequest) throws Exception {
        validaEntrada(personagemRequest);
        PersonagemAtor personagemAtor = new PersonagemAtor(atorService.consultarAtor(personagemRequest.getIdAtor()),
                personagemRequest.getNomePersonagem(), personagemRequest.getDescricaoPersonagem(),
                personagemRequest.getTipoAtuacao());
        validaAtor(personagemRequest);
        personagemAtorRepository.save(personagemAtor);
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
    }

    public void validaAtor(PersonagemRequest personagemRequest) throws Exception {
        //Valida existência de ator
        boolean flag = false;
        for (Ator ator:
                atorService.consultarAtores()) {
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

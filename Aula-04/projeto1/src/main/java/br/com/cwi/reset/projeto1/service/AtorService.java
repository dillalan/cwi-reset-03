package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.exception.ArtistaNaoEncontradoException;
import br.com.cwi.reset.projeto1.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public void criaAtor(Ator ator){
        atorRepository.save(ator);
    }

    public void apagaAtor(Integer id) throws ArtistaNaoEncontradoException {
        atorRepository.deleteById(id);
    }

    public Ator buscaAtorPorNome(String nome) throws ArtistaNaoEncontradoException {
        if (atorRepository.findByNome(nome)==null){
            throw new ArtistaNaoEncontradoException("Nenhum ator encontrado com o nome "+nome);
        }
        return atorRepository.findByNome(nome);
    }

    public List<Ator> buscaAtorPorNumeroDeOscars(Integer numeroOscars) throws ArtistaNaoEncontradoException {
        if (atorRepository.findByNumeroOscars(numeroOscars).size() == 0){
            throw new ArtistaNaoEncontradoException("Nenhum artista encontrado com filtro numeroOscars{"+numeroOscars+"}");
        }
        return atorRepository.findByNumeroOscars(numeroOscars);
    }

    public List<Ator> listar(){
        return atorRepository.findAll();
    }
}

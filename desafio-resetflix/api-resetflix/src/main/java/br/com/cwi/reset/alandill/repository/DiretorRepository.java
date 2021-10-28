package br.com.cwi.reset.alandill.repository;

import br.com.cwi.reset.alandill.domain.Diretor;
import br.com.cwi.reset.alandill.request.DiretorRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor, Integer> {

    List<Diretor> findDiretorByNome(String nome);

    Diretor findDiretorById(Integer id);

    List<Diretor> findAll();

}

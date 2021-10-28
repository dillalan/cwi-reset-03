package br.com.cwi.reset.alandill.repository;

import br.com.cwi.reset.alandill.domain.Ator;
import br.com.cwi.reset.alandill.request.AtorRequest;
import br.com.cwi.reset.alandill.response.AtorEmAtividade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {

    List<AtorEmAtividade> findAtorEmAtividadeByNome(String nome);

    Ator findAtorById(Integer id);

    List<Ator> findAll();

}

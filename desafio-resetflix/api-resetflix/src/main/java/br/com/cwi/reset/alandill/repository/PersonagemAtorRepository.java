package br.com.cwi.reset.alandill.repository;

import br.com.cwi.reset.alandill.domain.PersonagemAtor;
import br.com.cwi.reset.alandill.request.PersonagemRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemAtorRepository extends CrudRepository<PersonagemAtor, Integer> {

}

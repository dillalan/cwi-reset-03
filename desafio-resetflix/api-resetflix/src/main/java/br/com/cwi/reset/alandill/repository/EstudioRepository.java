package br.com.cwi.reset.alandill.repository;

import br.com.cwi.reset.alandill.domain.Estudio;
import br.com.cwi.reset.alandill.request.EstudioRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Integer> {

    Estudio findEstudioByNome(String nome);

    Estudio findEstudioById(Integer id);

    List<Estudio> findAll();


}

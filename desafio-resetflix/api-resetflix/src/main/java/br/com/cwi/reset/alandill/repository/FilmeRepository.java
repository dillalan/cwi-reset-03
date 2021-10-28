package br.com.cwi.reset.alandill.repository;

import br.com.cwi.reset.alandill.domain.Filme;
import br.com.cwi.reset.alandill.request.FilmeRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer>{

     List<Filme> findAll();

     Filme findFilmeByNome(String nome);

     //TODO consultar mais de um filtro
}

package br.com.cwi.reset.alandill.service;

import br.com.cwi.reset.alandill.domain.Estudio;
import br.com.cwi.reset.alandill.exception.*;
import br.com.cwi.reset.alandill.repository.EstudioRepository;
import br.com.cwi.reset.alandill.request.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    public void criarEstudio(EstudioRequest estudioRequest) throws TemporalException, ObrigatorioException, NomeException {
        validaInput(estudioRequest);
        Estudio estudio = new Estudio(estudioRequest.getNome(),estudioRequest.getDescricao(),
                estudioRequest.getDataCriacao(),estudioRequest.getStatusAtividade());
        estudioRepository.save(estudio);
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws NaoEncontradoException, SemCadastroException {
        if (estudioRepository.findAll().isEmpty()){
            throw new SemCadastroException("Nenhum estúdio cadastrado, favor cadastrar estúdio.");
        }
        List<Estudio> estudioConsultado = new ArrayList<>();
        boolean flag = false;
        if (filtroNome == null) {
            return estudioRepository.findAll();
        } else {
            for (Estudio estudio :
                    estudioRepository.findAll()) {
                if (estudio.getNome().equalsIgnoreCase(filtroNome)) {
                    estudioConsultado.add(estudio);
                    flag = true;
                    break;
                }
            }
            if (!flag){
                throw new NaoEncontradoException("Estúdio não encontrato com o filtro {" + filtroNome + "}, favor " +
                        "informar outro filtro.");
            }
            return estudioConsultado;
        }
    }

    public Estudio consultarEstudio(Integer id) throws ObrigatorioException, NaoEncontradoException, SemCadastroException {
        if (id == null) {
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {id}.");
        } else if (estudioRepository.findAll().isEmpty()){
            throw new SemCadastroException("Nenhum estúdio cadastrado, favor cadastrar estúdio.");
        }
        boolean flag = false;
        Estudio estudioConsultado = null;
        for (Estudio estudio :
                estudioRepository.findAll()) {
            if (estudio.getId() == id) {
                estudioConsultado = estudio;
                flag = true;
                break;
            }
        }
        if (!flag){
            throw new NaoEncontradoException("Nenhum estúdio encontrado com o parâmetro id={" + id + "}, favor " +
                    "verifique os parâmetros informados.");
        }
        return estudioConsultado;
    }

    public void validaInput(EstudioRequest estudioRequest) throws ObrigatorioException, TemporalException, NomeException {
        if (estudioRequest.getNome() == null) {
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {nome}");
        } else if (estudioRequest.getDataCriacao() == null) {
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {dataCriacao}");
        } else if (estudioRequest.getDescricao() == null) {
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {descricao}");
        }
        if (estudioRequest.getDataCriacao().isAfter(LocalDate.now())) {
            throw new TemporalException("Não é possível cadastrar estúdios do futuro.");
        }

        for (Estudio estudio :
                estudioRepository.findAll()) {
            if (estudio.getNome().equals(estudioRequest.getNome())) {
                throw new NomeException("Já existe um diretor cadastrado para o nome {" + estudioRequest.getNome() + "}.");
            }
        }
    }
}

package br.com.cwi.reset.alandill.service;

import br.com.cwi.reset.alandill.FakeDatabase;
import br.com.cwi.reset.alandill.domain.Diretor;
import br.com.cwi.reset.alandill.domain.Estudio;
import br.com.cwi.reset.alandill.exception.*;
import br.com.cwi.reset.alandill.request.EstudioRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstudioService {

    private FakeDatabase fakeDatabase;
    private Integer incremento = 1;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest) throws TemporalException, ObrigatorioException, NomeException {
        validaInput(estudioRequest);
        estudioRequest.setId(this.incremento);
        this.fakeDatabase.persisteEstudio(estudioRequest);
        ++this.incremento;
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws NaoEncontradoException, SemCadastroException {
        if (this.fakeDatabase.recuperaEstudios().isEmpty()){
            throw new SemCadastroException("Nenhum estúdio cadastrado, favor cadastrar estúdio.");
        }
        List<Estudio> estudioConsultado = new ArrayList<>();
        boolean flag = false;
        if (filtroNome == null) {
            return this.fakeDatabase.recuperaEstudios();
        } else {
            for (Estudio estudio :
                    this.fakeDatabase.recuperaEstudios()) {
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
        } else if (this.fakeDatabase.recuperaEstudios().isEmpty()){
            throw new SemCadastroException("Nenhum estúdio cadastrado, favor cadastrar estúdio.");
        }
        boolean flag = false;
        Estudio estudioConsultado = null;
        for (Estudio estudio :
                this.fakeDatabase.recuperaEstudios()) {
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
                this.fakeDatabase.recuperaEstudios()) {
            if (estudio.getNome().equals(estudioRequest.getNome())) {
                throw new NomeException("Já existe um diretor cadastrado para o nome {" + estudioRequest.getNome() + "}.");
            }
        }
    }
}

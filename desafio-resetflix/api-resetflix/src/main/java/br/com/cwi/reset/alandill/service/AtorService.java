package br.com.cwi.reset.alandill.service;

import br.com.cwi.reset.alandill.repository.AtorRepository;
import br.com.cwi.reset.alandill.response.AtorEmAtividade;
import br.com.cwi.reset.alandill.domain.Ator;
import br.com.cwi.reset.alandill.domain.StatusCarreira;
import br.com.cwi.reset.alandill.exception.*;
import br.com.cwi.reset.alandill.request.AtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;


    public void criarAtor(AtorRequest atorRequest) throws NomeException, TemporalException, ObrigatorioException {

        validaEntrada(atorRequest);

        Ator ator = new Ator(atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(),
                atorRequest.getAnoInicioAtividade());
        repository.save(ator);
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws NaoEncontradoException, SemCadastroException {

        List<AtorEmAtividade> emAtividade = new ArrayList<>();
        String stringDoFiltro = filtroNome.toLowerCase();
        String stringDaDatabase;
        boolean flag = false;

        if (repository.findAll().isEmpty()) {
            throw new SemCadastroException("Nenhum ator cadastrado, favor cadastrar atores.");
        } else if (filtroNome.isEmpty()) {
            for (Ator ator :
                    repository.findAll()) {
                if (ator.getStatusCarreira() == StatusCarreira.EM_ATIVIDADE) {
                    emAtividade.add(new AtorEmAtividade(ator.getNome(), ator.getDataNascimento(), ator.getAnoInicioAtividade()));
                }
            }
        } else {
            for (Ator ator :
                    repository.findAll()) {
                stringDaDatabase = ator.getNome().toLowerCase();
                if (stringDaDatabase.contains(stringDoFiltro)) {
                    if (ator.getStatusCarreira() == StatusCarreira.EM_ATIVIDADE) {
                        emAtividade.add(new AtorEmAtividade(ator.getNome(), ator.getDataNascimento(),
                                ator.getAnoInicioAtividade()));
                        flag = true;
                    }
                }
            }
            if (!flag) {
                throw new NaoEncontradoException("Ator não encontrado com o filtro {" + filtroNome + "}, favor informar " +
                        "outro filtro.");
            }
        }
        return emAtividade;
    }

    public Ator consultarAtor(Integer id) throws NaoEncontradoException, ObrigatorioException {

        boolean flag = false;
        Ator atorConsultado = null;

        if (id == null) {
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {Integer id}.");
        }

        for (Ator ator :
                repository.findAll()) {
            if (ator.getId() == id) {
                atorConsultado = ator;
                flag = true;
                break;
            }
        }

        if (!flag) {
            throw new NaoEncontradoException("Nenhum ator encontrado com o parâmetro id={" + id + "}, favor " +
                    "verifique os parâmetros informados.");
        }
        return atorConsultado;
    }


    public List<Ator> consultarAtores() throws SemCadastroException {
        if (repository.findAll().isEmpty()) {
            throw new SemCadastroException("Nenhum ator cadastrado, favor cadastrar atores.");
        }
        return repository.findAll();
    }

    public void validaEntrada(AtorRequest atorRequest) throws ObrigatorioException, NomeException, TemporalException {
        if (atorRequest.getNome().isEmpty()) {
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o " +
                    "campo {AtorRequest atorRequest}.");
        } else if (atorRequest.getNome().split(" ").length < 2) {
            throw new NomeException("Deve ser informado no mínimo nome e sobrenome para o ator.");
        } else if (atorRequest.getDataNascimento().isAfter(LocalDate.from(LocalDate.now()))) {
            throw new TemporalException("Não é possível cadastrar atores não nascidos.");
        } else if (atorRequest.getAnoInicioAtividade() < atorRequest.getDataNascimento().getYear()) {
            throw new TemporalException("Ano de início de atividade inválido para o ator cadastrado.");
        }
        for (Ator ator :
                repository.findAll()) {
            if (ator.getNome().equals(atorRequest.getNome())) {
                throw new NomeException("Já existe um ator cadastrado para o nome {" + atorRequest.getNome() + "}");
            }
        }
    }
}

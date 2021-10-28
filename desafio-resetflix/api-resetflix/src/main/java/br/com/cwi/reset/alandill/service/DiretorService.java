package br.com.cwi.reset.alandill.service;

import br.com.cwi.reset.alandill.domain.Diretor;
import br.com.cwi.reset.alandill.exception.*;
import br.com.cwi.reset.alandill.repository.DiretorRepository;
import br.com.cwi.reset.alandill.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws NomeException, TemporalException, ObrigatorioException {
        if (diretorRequest.getNome().isEmpty()) {
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o " +
                    "campo {DiretorRequest diretorRequest}.");
        } else if (diretorRequest.getNome().split(" ").length < 2) {
            throw new NomeException("Deve ser informado no mínimo nome e sobrenome para o diretor.");
        } else if (diretorRequest.getDataNascimento().isAfter(LocalDate.now())) {
            throw new TemporalException("Não é possível cadastrar diretores não nascidos.");
        } else if (diretorRequest.getAnoInicioAtividade() < diretorRequest.getDataNascimento().getYear()) {
            throw new TemporalException("Ano de início de atividade inválido para o diretor cadastrado.");
        }
        for (Diretor diretor :
                diretorRepository.findAll()) {
            if (diretor.getNome().equals(diretorRequest.getNome())) {
                throw new NomeException("Já existe um diretor cadastrado para o nome {" + diretorRequest.getNome() + "}.");
            }
        }
        Diretor diretor = new Diretor(diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());
        diretorRepository.save(diretor);
    }

    public List<Diretor> listarDiretores(String nome) throws SemCadastroException, NaoEncontradoException {

        List<Diretor> diretorFiltrado = new ArrayList<>();

        if (diretorRepository.findAll().isEmpty()) {
            throw new SemCadastroException("Nenhum diretor cadastrado, favor cadastrar diretores.");
        } else if (nome == null) {
            return diretorRepository.findAll();
        } else {
            String stringDoFiltro = nome.toLowerCase();
            String stringDaDatabase;
            boolean flag = false;

            for (Diretor diretor :
                    diretorRepository.findAll()) {
                stringDaDatabase = diretor.getNome().toLowerCase();
                if (stringDaDatabase.contains(stringDoFiltro)) {
                    diretorFiltrado.add(diretor);
                    flag = true;
                }
            }
            if (!flag) {
                throw new NaoEncontradoException("Diretor não encontrado com o filtro {" + nome + "}, favor informar " +
                        "outro filtro.");
            }
        }
        return diretorFiltrado;
    }

    public Diretor consultarDiretor(Integer id) throws NaoEncontradoException, ObrigatorioException {
        Diretor diretorConsultado = new Diretor("", LocalDate.of(2019, 11, 5), 2019);
        boolean flag = false;

        if (id == null) {
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {Integer id}.");
        }
        for (Diretor diretor :
                diretorRepository.findAll()) {
            if (diretor.getId() == id) {
                diretorConsultado = diretor;
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new NaoEncontradoException("Nenhum diretor encontrado com o parâmetro id={" + id + "}, favor verifique os parâmetros informados.");
        }
        return diretorConsultado;
    }
}

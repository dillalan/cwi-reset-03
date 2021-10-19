package br.com.cwi.reset.alandill.service;

import br.com.cwi.reset.alandill.response.AtorEmAtividade;
import br.com.cwi.reset.alandill.FakeDatabase;
import br.com.cwi.reset.alandill.domain.Ator;
import br.com.cwi.reset.alandill.domain.StatusCarreira;
import br.com.cwi.reset.alandill.exception.*;
import br.com.cwi.reset.alandill.request.AtorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtorService {
    private FakeDatabase fakeDatabase;
    private Integer incremento = 1;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public Integer getIncremento() {
        return incremento;
    }

    public void setIncremento() {
        this.incremento += 1;
    }

    public void imprimePerfil(Ator ator){
        System.out.println("Nome: "+ator.getNome());
        System.out.println("Data de Nascimento: "+ator.getDataNascimento());
        System.out.println("Ano de início de atividade: "+ator.getAnoInicioAtividade());
        System.out.println("Status da Carreira: "+ator.getStatusCarreira());
    }

    public void criarAtor(AtorRequest atorRequest) throws NomeException, TemporalException {
        if (!atorRequest.getNome().contains(" ")){
            throw new NomeException("Deve ser informado no mínimo nome e sobrenome para o ator.");
        } else if (atorRequest.getDataNascimento().isAfter(LocalDate.from(LocalDate.now()))){
            throw new TemporalException("Não é possível cadastrar atores não nascidos.");
        } else if (atorRequest.getAnoInicioAtividade()<atorRequest.getDataNascimento().getYear()){
            throw new TemporalException("Ano de início de atividade inválido para o ator cadastrado.");
        }
        for (Ator ator:
                fakeDatabase.recuperaAtores()) {
            if (ator.getNome().equals(atorRequest.getNome())){
                throw new NomeException("Já existe um ator cadastrado para o nome {"+atorRequest.getNome()+"}");
            }
        }
        atorRequest.setId(getIncremento());
        fakeDatabase.persisteAtor(atorRequest);
        setIncremento();
    }

    public void criarAtor() throws ObrigatorioException {
        throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o " +
                "campo {AtorRequest atorRequest}.");
    }


    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws NaoEncontradoException {
        List<AtorEmAtividade> emAtividade = new ArrayList<>();
        String stringDoFiltro = filtroNome.toLowerCase();
        String stringDaDatabase;
        boolean flag = false;
        for (Ator ator:
             this.fakeDatabase.recuperaAtores()) {
            stringDaDatabase = ator.getNome().toLowerCase();
            if (stringDaDatabase.contains(stringDoFiltro)){
                if (ator.getStatusCarreira()== StatusCarreira.EM_ATIVIDADE){
                    emAtividade.add(new AtorEmAtividade(ator.getNome(), ator.getDataNascimento(),
                            ator.getAnoInicioAtividade()));
                    flag = true;
                }
            }
        }
        if (!flag){
            throw new NaoEncontradoException("Ator não encontrado com o filtro {"+filtroNome+"}, favor informar " +
                    "outro filtro.");
        }
        return emAtividade;
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade() throws SemCadastroException {
        if (this.fakeDatabase.recuperaAtores().isEmpty()){
            throw new SemCadastroException("Nenhum ator cadastrado, favor cadastrar atores.");
        }
        List<AtorEmAtividade> emAtividade = new ArrayList<>();
        for (Ator ator:
                this.fakeDatabase.recuperaAtores()) {
            if (ator.getStatusCarreira()==StatusCarreira.EM_ATIVIDADE){
                emAtividade.add(new AtorEmAtividade(ator.getNome(), ator.getDataNascimento(), ator.getAnoInicioAtividade()));
            }
        }
        return emAtividade;
    }

    public Ator consultarAtor(Integer id) throws NaoEncontradoException {
        boolean flag = false;
        Ator atorConsultado = new Ator("", LocalDate.of(2019,11,5), StatusCarreira.EM_ATIVIDADE, 2022);
        for (Ator ator :
                this.fakeDatabase.recuperaAtores()) {
            if (ator.getId()==id){
                atorConsultado = ator;
                flag = true;
                break;
            }
        }
        if (!flag){
            throw new NaoEncontradoException("Nenhum ator encontrado com o parâmetro id={"+id+"}, favor " +
                    "verifique os parâmetros informados.");
        }
        return atorConsultado;
    }

    public Ator consultarAtor() throws ObrigatorioException{
        throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {Integer id}.");
    }

    public List<Ator> consultarAtores() throws SemCadastroException{
        if (this.fakeDatabase.recuperaAtores().isEmpty()){
            throw new SemCadastroException("Nenhum ator cadastrado, favor cadastrar atores.");
        }
        return this.fakeDatabase.recuperaAtores();
    }
}
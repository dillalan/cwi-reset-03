package br.com.cwi.reset.alandill.service;

import br.com.cwi.reset.alandill.FakeDatabase;
import br.com.cwi.reset.alandill.domain.*;
import br.com.cwi.reset.alandill.exception.NaoEncontradoException;
import br.com.cwi.reset.alandill.exception.NomeException;
import br.com.cwi.reset.alandill.exception.ObrigatorioException;
import br.com.cwi.reset.alandill.request.FilmeRequest;
import br.com.cwi.reset.alandill.request.PersonagemRequest;

import java.util.*;
import java.util.stream.Collectors;

public class FilmeService {
    private FakeDatabase fakeDatabase;
    private DiretorService diretorService;
    private AtorService atorService;


    public FilmeService(FakeDatabase fakeDatabase) {
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
        this.atorService = new AtorService(FakeDatabase.getInstance());
        this.fakeDatabase = fakeDatabase;
    }

    public void criarFilme(FilmeRequest filmeRequest) throws ObrigatorioException, NomeException, NaoEncontradoException {
        validaEntrada(filmeRequest);
        Filme filme = new Filme(filmeRequest.getNome(), filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(),
                filmeRequest.getGeneros(), diretorService.consultarDiretor(filmeRequest.getIdDiretor()),
                listarPersonagens(filmeRequest), filmeRequest.getResumo());
        this.fakeDatabase.persisteFilme(filme);
    }

    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws NaoEncontradoException {
        List<Filme> filtroTitulo = new ArrayList<>();
        List<Filme> filtroDiretor = new ArrayList<>();
        List<Filme> filtroPersonagem = new ArrayList<>();
        List<Filme> filtroAtor = new ArrayList<>();
        List<List<Filme>> filmesEncontrados = new ArrayList<>();
        List<List<Filme>> filmesEncontradosSorted = new ArrayList<>();
        
        boolean flag = false;

        // Filtrando pelo título do filme
        if(nomeFilme!=null){
            for (Filme filme:
                 this.fakeDatabase.recuperaFilmes()) {
                if (filme.getNome().contains(nomeFilme)){
                    filtroTitulo.add(filme);
                    filmesEncontrados.add(filtroTitulo);
                    flag = true;
                }
            }

        }
        
        // Filtrando pelo Diretor
        if (nomeDiretor!=null){
            for (Filme filme:
                    this.fakeDatabase.recuperaFilmes()) {
                if (filme.getDiretor().getNome().contains(nomeDiretor)){
                    filtroDiretor.add(filme);
                    filmesEncontrados.add(filtroDiretor);
                    flag = true;
                }
            }
        }
        
        // Filtrando por personagem
        if (nomePersonagem!=null){
            for (Filme filme :
                    this.fakeDatabase.recuperaFilmes()) {
                if (contemPersonagem(filme.getPersonagens(), nomePersonagem)){
                    filtroPersonagem.add(filme);
                    filmesEncontrados.add(filtroPersonagem);
                    flag = true;
                }
            }
        }

        // Filtrando por Ator
        if (nomeAtor!=null){
            for (Filme filme:
                 this.fakeDatabase.recuperaFilmes()) {
                if (contemAtor(filme.getPersonagens(), nomeAtor)){
                    filtroAtor.add(filme);
                    filmesEncontrados.add(filtroAtor);
                    flag = true;
                }
            }
        }


        // Se nenhum filtro encontrou resultado...
        if(!flag){
            throw new NaoEncontradoException("Filme não encontrado com os filtros nomeFilme={"+nomeFilme+"}, " +
                    "nomeDiretor={"+nomeDiretor+"}, nomePersonagem={"+nomePersonagem+"}, nomeAtor={"+nomeAtor+"}, " +
                    "favor informar outros filtros.");
        } else{
            //Se algum filtro retornar resultado, retornamos o resultado mais estrito da combinação de filtros
            filmesEncontradosSorted = filmesEncontrados.stream().sorted(Comparator.comparingInt(List::size)).collect(Collectors.toList());
        }
        return filmesEncontradosSorted.get(0);
    }

    private void validaEntrada(FilmeRequest filmeRequest) throws ObrigatorioException, NomeException, NaoEncontradoException {
        // Valida parametros obrigatórios
        if (filmeRequest.getNome() == null) {
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {nome}");
        } else if (filmeRequest.getAnoLancamento() == null) {
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {anoLancamento}");
        } else if (filmeRequest.getCapaFilme() == null) {
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {capaFilme}");
        }else if (filmeRequest.getGeneros()==null) {
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {generos}");
        }else if (filmeRequest.getIdDiretor()==null){
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {idDiretor}");
        } else if (filmeRequest.getIdEstudio() == null){
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {idEstudio}");
        } else if (filmeRequest.getResumo()==null){
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {resumo}");
        } else if (filmeRequest.getPersonagens()==null){
            throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {personagens}");
        }

        // Valida cadastro de ator, diretor e estúdio
        boolean flag = false;

        for (Estudio estudio :
            this.fakeDatabase.recuperaEstudios()){
            if (estudio.getId()==filmeRequest.getIdEstudio()){
                flag = true;
                break;
            }
        }
        if (!flag){
            throw new NaoEncontradoException("Nenhum estúdio encontrado com o parâmetro id={"+filmeRequest.getIdEstudio()+"}, favor verifique os parâmetros informados.");
        }

        for (Diretor diretor:
             this.fakeDatabase.recuperaDiretores()) {
            if (diretor.getId() == filmeRequest.getIdDiretor()) {
                flag = true;
                break;
            }
        }
        if (!flag){
            throw new NaoEncontradoException("Nenhum diretor encontrado com o parâmetro id={"+filmeRequest.getIdDiretor()+"}, favor verifique os parâmetros informados.");
        }

        // Valida ao menos um genero
        if (filmeRequest.getGeneros().size()<1){
            throw new NaoEncontradoException("Deve ser informado pelo menos um gênero para o cadastro do filme.");
        }

        // TODO Valida genero unico para conjunto de genero

        // TODO Valida personagem feito pelo mesmo ator apenas uma vez
    }

    private List<PersonagemAtor> listarPersonagens(FilmeRequest filmeRequest) throws NaoEncontradoException, ObrigatorioException {
        List<PersonagemAtor> personagensListados = new ArrayList<>();
        for (PersonagemRequest personagem:
                filmeRequest.getPersonagens()) {
            personagensListados.add(new PersonagemAtor(atorService.consultarAtor(personagem.getIdAtor()),
                    personagem.getNomePersonagem(), personagem.getDescricaoPersonagem(), personagem.getTipoAtuacao()));
        }
        return personagensListados;
    }

    private boolean contemPersonagem(List<PersonagemAtor> listaDePersonagens, String essePersonagem){
        for (PersonagemAtor personagem :
               listaDePersonagens ) {
            if (personagem.getNomePersonagem().contains(essePersonagem)){
                return true;
            }
        }
        return false;
    }

    private boolean contemAtor(List<PersonagemAtor> listaDePersonagens, String esseAtor){
        for (PersonagemAtor personagem :
                listaDePersonagens) {
            if (personagem.getAtor().getNome().contains(esseAtor)) {
                return true;
            }
        }
        return false;
    }
}

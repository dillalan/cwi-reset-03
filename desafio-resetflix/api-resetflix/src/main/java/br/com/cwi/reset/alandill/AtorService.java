package br.com.cwi.reset.alandill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AtorService {
    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void imprimePerfil(Ator ator){
        System.out.println("Nome: "+ator.getNome());
        System.out.println("Data de Nascimento: "+ator.getDataNascimento());
        System.out.println("Ano de início de atividade: "+ator.getAnoInicioAtividade());
        System.out.println("Status da Carreira: "+ator.getStatusCarreira());
    }

    public void criarAtor(AtorRequest atorRequest) {
        fakeDatabase.persisteAtor(atorRequest);
        //TODO Exceção: Campo obrigatório faltando -> Incluir mensagem de erro: "Campo obrigatório não informado. Favor
        // informar o campo {campo}."

        //TODO Exceção: Campo nome deve assegurar nome e sobrenome -> Incluir mensagem de erro: "Deve ser informado no
        // mínimo nome e sobrenome para o ator."

        //TODO Exceção: Campo dataNascimento maior que data atual -> Incluir mensagem de erro: "Não é possível cadastrar
        // atores não nascidos."

        //TODO Exceção: Campo anoInicioAtividade anterior ao nascimento -> Incluir mensagem de erro: "Ano de início de
        // atividade inválido para o ator cadastrado."

        //TODO Exceção: Dois atores de mesmo nome -> Incluir mensagem de erro: "Já existe um ator cadastrado para o
        // nome {nome}."
    }


    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws NaoEncontradoException{
        List<AtorEmAtividade> emAtividade = new ArrayList<>();
        String stringDoFiltro = filtroNome.toLowerCase();
        String stringDaDatabase;

        for (Ator ator:
             this.fakeDatabase.recuperaAtores()) {
            stringDaDatabase = ator.getNome().toLowerCase();
            if (stringDaDatabase.contains(stringDoFiltro)){
                if (ator.getStatusCarreira()==StatusCarreira.EM_ATIVIDADE){
                    emAtividade.add(new AtorEmAtividade(ator.getNome(), ator.getDataNascimento(),
                            ator.getAnoInicioAtividade()));
                }
            }
            else {
                throw new NaoEncontradoException("Ator não encontrado com o filtro {"+filtroNome+"}, favor informar outro filtro.");
            }
        }
        return emAtividade;
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade() throws SemCadastroException{
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

        //TODO Exceção: Sem atores cadastrados -> retornar a mensagem de erro: "Nenhum ator cadastrado, favor cadastrar
        // atores."
    }

    public Ator consultarAtor(Integer id) throws NaoEncontradoException {

        Ator atorConsultado = new Ator("", LocalDate.of(2019,11,5), StatusCarreira.EM_ATIVIDADE, 2022);
        for (Ator ator :
                this.fakeDatabase.recuperaAtores()) {
            if (ator.getId()==id){
                atorConsultado = ator;
            } else{
                throw new NaoEncontradoException("Nenhum ator encontrado com o parâmetro id={"+id+"}, favor " +
                        "verifique os parâmetros informados.");
            }
        }
        return atorConsultado;

        //TODO Exceção: Campo id obrigatório -> retorna mensagem de erro: "Campo obrigatório não informado. Favor
        // informar o campo {campo}."
    }

    public List<Ator> consultarAtores(){
        return this.fakeDatabase.recuperaAtores();
        //TODO Exceção: Nenhum ator cadastrado -> retornar a mensagem de erro: "Nenhum ator cadastrado, favor cadastrar
        // atores."
    }
}

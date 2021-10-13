package br.com.cwi.reset.alandill;

import java.util.ArrayList;
import java.util.List;

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

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome){
        filtroNome = (filtroNome!=null ? filtroNome:""); // Se filtro nome for diferente nulo, filtroNome recebe o parâmetro.
        List<AtorEmAtividade> emAtividade = new ArrayList<>();
        for (Ator ator:
             this.fakeDatabase.recuperaAtores()) {
            if (ator.getStatusCarreira()==StatusCarreira.EM_ATIVIDADE){
                emAtividade.add(new AtorEmAtividade(ator.getNome(), ator.getDataNascimento(), ator.getAnoInicioAtividade()));
            }
        }
        return emAtividade;

        //TODO Campo filtroNome é opcional, quando informado deve filtrar por qualquer match na sequência do nome.

        //TODO Exceção: Sem atores cadastrados -> retornar a mensagem de erro: "Nenhum ator cadastrado, favor cadastrar
        // atores."

        //TODO Exceção: Sem resultados para filtroNome -> retornar a mensagem de erro: "Ator não encontrato com o
        // filtro {filtro}, favor informar outro filtro."
    }

    public void consultarAtor(Integer id){
        for (Ator ator :
                this.fakeDatabase.recuperaAtores()) {
            if (ator.getId()==id){
                imprimePerfil(ator);
                break;
            }
        }

        //TODO Exceção: Campo id obrigatório -> retorna mensagem de erro: "Campo obrigatório não informado. Favor
        // informar o campo {campo}."

        //TODO Exceção: Ator não encontrado -> retornar a mensagem de erro: "Nenhum ator encontrado com o parâmetro
        // id={campo}, favor verifique os parâmetros informados."
    }

    public List<Ator> consultarAtores(){
        return this.fakeDatabase.recuperaAtores();
    }
}

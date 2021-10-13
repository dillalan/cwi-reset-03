package br.com.cwi.reset.alandill;

import java.time.LocalDate;
import java.util.List;

public class DiretorService {
    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void imprimePerfil(Diretor diretor){
        System.out.println("Nome: "+diretor.getNome());
        System.out.println("Data de Nascimento: "+diretor.getDataNascimento());
        System.out.println("Ano de início de atividade: "+diretor.getAnoInicioAtividade());
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest){
        this.fakeDatabase.persisteDiretor(diretorRequest);

        //TODO Exceção: Campo obrigatório faltando -> Incluir mensagem de erro: "Campo obrigatório não informado. Favor
        // informar o campo {campo}."

        //TODO Exceção: Campo nome deve assegurar nome e sobrenome -> Incluir mensagem de erro: "Deve ser informado no
        // mínimo nome e sobrenome para o diretor."

        //TODO Exceção: Campo dataNascimento maior que data atual -> Incluir mensagem de erro: "Não é possível cadastrar
        // diretores não nascidos."

        //TODO Exceção: Campo anoInicioAtividade anterior ao nascimento -> Incluir mensagem de erro: "Ano de início de
        // atividade inválido para o diretor cadastrado."

        //TODO Exceção: Dois atores de mesmo nome -> Incluir mensagem de erro: "Já existe um diretor cadastrado para o
        // nome {nome}."
    }

    public List<Diretor> listarDiretores(String filtroNome){
        return this.fakeDatabase.recuperaDiretores();

        //TODO Campo filtroNome é opcional, quando informado deve filtrar por qualquer match na sequência do nome.

        //TODO Exceção: Sem diretores cadastrados -> retornar a mensagem de erro: "Nenhum diretor cadastrado, favor
        // cadastrar diretores."

        //TODO Exceção: Sem match no filtro -> retornar a mensagem de erro: "Diretor não encontrado com o filtro
        // {filtro}, favor informar outro filtro."
    }

    public Diretor consultarDiretor(Integer id) throws NaoEncontradoException {
        Diretor diretorConsultado = new Diretor("", LocalDate.of(2019,11,5), 2019);
        for (Diretor diretor :
                this.fakeDatabase.recuperaDiretores()) {
            if (diretor.getId()==id){
                diretorConsultado = diretor;
            }
            else {
                throw new NaoEncontradoException("Nenhum diretor encontrado com o parâmetro id={"+id+"}, favor verifique os parâmetros informados.");
            }
        }
        //TODO Exceção: Campo id obrigatório -> retorna mensagem de erro: "Campo obrigatório não informado. Favor
        // informar o campo {campo}."
    return diretorConsultado;
    }

}

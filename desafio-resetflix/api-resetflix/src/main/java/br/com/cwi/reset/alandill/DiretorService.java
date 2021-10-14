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

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws NomeException, TemporalException {
        if (!diretorRequest.getNome().contains(" ")){
            throw new NomeException("Deve ser informado no mínimo nome e sobrenome para o diretor.");
        } else if (diretorRequest.getDataNascimento().isAfter(LocalDate.now())){
            throw new TemporalException("Não é possível cadastrar diretores não nascidos.");
        } else if (diretorRequest.getAnoInicioAtividade()<diretorRequest.getDataNascimento().getYear()){
            throw new TemporalException("Ano de início de atividade inválido para o diretor cadastrado.");
        }
        for (Diretor diretor :
                this.fakeDatabase.recuperaDiretores()) {
            if (diretor.getNome().equals(diretorRequest.getNome())){
                throw new NomeException("á existe um diretor cadastrado para o nome {"+diretorRequest.getNome()+"}.");
            }
        }
        this.fakeDatabase.persisteDiretor(diretorRequest);
    }

    public void cadastrarDiretor() throws ObrigatorioException {
        throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {DiretorRequest diretorRequest}.");
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

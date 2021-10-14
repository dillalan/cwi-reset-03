package br.com.cwi.reset.alandill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiretorService {
    private FakeDatabase fakeDatabase;
    private Integer incremento = 1;
    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public Integer getIncremento() {
        return incremento;
    }

    public void setIncremento() {
        this.incremento += 1;
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
                throw new NomeException("Já existe um diretor cadastrado para o nome {"+diretorRequest.getNome()+"}.");
            }
        }
        diretorRequest.setId(getIncremento());
        this.fakeDatabase.persisteDiretor(diretorRequest);
        setIncremento();
    }

    public void cadastrarDiretor() throws ObrigatorioException {
        throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {DiretorRequest diretorRequest}.");
    }

    public List<Diretor> listarDiretores(String filtroNome) throws SemCadastroException, NaoEncontradoException {
        if (this.fakeDatabase.recuperaDiretores().isEmpty()) {
            throw new SemCadastroException("Nenhum diretor cadastrado, favor cadastrar diretores.");
        }
        List <Diretor> diretorFiltrado = new ArrayList<>();
        String stringDoFiltro = filtroNome.toLowerCase();
        String stringDaDatabase;
        boolean flag = false;
        for (Diretor diretor:
             this.fakeDatabase.recuperaDiretores()) {
            stringDaDatabase = diretor.getNome().toLowerCase();
            if (stringDaDatabase.contains(stringDoFiltro)){
                diretorFiltrado.add(diretor);
                flag = true;
            }
        }
        if(!flag){
            throw new NaoEncontradoException("Diretor não encontrado com o filtro {"+filtroNome+"}, favor informar " +
                    "outro filtro.");
        }
        return diretorFiltrado;
    }

    public List<Diretor> listarDiretores() throws SemCadastroException {
        if (this.fakeDatabase.recuperaDiretores().isEmpty()) {
            throw new SemCadastroException("Nenhum diretor cadastrado, favor cadastrar diretores.");
        }
        return this.fakeDatabase.recuperaDiretores();
    }


    public Diretor consultarDiretor(Integer id) throws NaoEncontradoException {
        Diretor diretorConsultado = new Diretor("", LocalDate.of(2019,11,5), 2019);
        boolean flag = false;

        for (Diretor diretor :
                this.fakeDatabase.recuperaDiretores()) {
            if (diretor.getId() == id) {
                diretorConsultado = diretor;
                flag = true;
                break;
            }
        }
        if (!flag){
            throw new NaoEncontradoException("Nenhum diretor encontrado com o parâmetro id={"+id+"}, favor verifique os parâmetros informados.");
        }
    return diretorConsultado;
    }

    public Diretor consultarDiretor() throws ObrigatorioException {
        throw new ObrigatorioException("Campo obrigatório não informado. Favor informar o campo {Integer id}.");
    }
}

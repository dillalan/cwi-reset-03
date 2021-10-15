public class Filme {
    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer anoLancamento;
    private Double avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Double avaliacao, Diretor diretor) throws AvaliacaoForaDoPadraoException {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
        validarAvaliacao();
    }

    public void reproduzir(){
        System.out.println("Título: "+this.nome);
        System.out.println("Descrição: "+this.descricao);
        System.out.println("Duração: "+this.duracao+" minutos");
        System.out.println("Diretor "+this.diretor.getNome());
    }

    private void validarAvaliacao() throws AvaliacaoForaDoPadraoException {
        if (this.avaliacao > 5 || this.avaliacao < 1){
            throw new AvaliacaoForaDoPadraoException("Erro! Parâmetro avaliacao deve ser maior que um e menor do que 5");
        }
    }
}

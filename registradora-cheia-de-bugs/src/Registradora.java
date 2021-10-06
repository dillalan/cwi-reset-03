
public class Registradora {

    public static void main(String[] args) {

//      Rodar um bug de cada vez!
        primeiroBug();

//        segundoBug();

//        terceiroBug();

//        quartoBug();

//        quintoBug();

//        sextoBug();
    }

    private static double registrarItem(String item, int quantidade) {
        confereEstoque();
        return RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
    }

    public static void confereEstoque(){
        String[] itens = {"pao", "sanduiche", "torta", "leite", "cafe"};
        for (String produto:
                itens) {
            if (QuantidadeMinimaItem.precisaReposicao(produto)) {
                if ("pao".equals(produto) || "sanduiche".equals(produto) || "torta".equals(produto)) {
                    if (!DataProjeto.cozinhaEmFuncionamento()) {
                        System.out.println("Cozinha fechada!\n -----------");
                        System.out.println("Estoque Disponível:");
                        System.out.println("Pão: "+ItensPorQuantidade.getPao()+" gramas --> "+
                                ItensPorQuantidade.getPao()/60+" unidades");
                        System.out.println("Sanduíches: "+ItensPorQuantidade.getSanduiche()+" unidades");
                        System.out.println("Tortas: "+ItensPorQuantidade.getTorta()+" unidades --> "+
                                ItensPorQuantidade.getTorta()*16+" fatias"+"\n -----------");
                    } else {
                        ReposicaoCozinha.reporItem(produto);
                    }
                } else if ("leite".equals(produto) || "cafe".equals(produto)){
                    ReposicaoFornecedor.reporItem(produto);
                }
            }
        }
    }

    private static void primeiroBug() {
        /*
        A string enviada para resgistrarItem é 'sanduiche' e causando falha ao ser comparada com 'sanduba'
        A desambiguação do termo corrige o defeito(sanduiche==sanduiche)
         */
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void segundoBug() {
        /*
        A expressão de calculo de precoTotal para o item torta é divisão de inteiros que gera um resultado
        inteiro de ZERO. Corrigido com a transformação para double.
         */
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void terceiroBug() {
        /*
        Diferença de strings para o objeto item de valor 'café. A desambiguação do termo corrige o
        defeito(cafe==cafe)
         */
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

}

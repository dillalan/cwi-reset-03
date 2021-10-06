public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            if (ItensPorQuantidade.getPao()<qtd){
                System.out.println("Lamentamos, mas temos apenas "+ItensPorQuantidade.getPao()/60+" unidades.");
                if (DataProjeto.cozinhaEmFuncionamento()){
                    ReposicaoCozinha.reporItem(item);
                    System.out.println("A cozinha já está preparando mais!");
                    System.out.println("...\nPronto!");
                }
            } else {
                precoTotal = 12.75 * (qtd * (double) 60 / (double) 1000);
                ItensPorQuantidade.setPao((ItensPorQuantidade.getPao() - qtd));
            }
        }

        if ("torta".equals(item)) {
            if ((ItensPorQuantidade.getTorta()*16)<qtd){
                System.out.println("Lamentamos, mas temos apenas "+ItensPorQuantidade.getTorta()+" unidades.");
                if (DataProjeto.cozinhaEmFuncionamento()){
                    ReposicaoCozinha.reporItem(item);
                    System.out.println("A cozinha já está preparando mais!");
                    System.out.println("...\nPronto!");
                }
            } else {
                precoTotal = 96.00 * ((double) qtd / (double) 16);
                ItensPorQuantidade.setTorta(((ItensPorQuantidade.getTorta() * 16) - qtd));
            }
        }

        if ("leite".equals(item)) {
            if (ItensPorQuantidade.getLeite()<qtd){
                System.out.println("Lamentamos, mas temos apenas "+ItensPorQuantidade.getLeite()+" unidades.");
                ReposicaoFornecedor.reporItem(item);
                System.out.println("Estamos providenciando mais, é só aguardar!");
                System.out.println("...\nPronto!");
            }
            precoTotal = 4.48 * qtd;
            ItensPorQuantidade.setLeite((ItensPorQuantidade.getLeite() - qtd));
        }

        if ("cafe".equals(item)) {
            if (ItensPorQuantidade.getCafe()<qtd){
                System.out.println("Lamentamos, mas temos apenas "+ItensPorQuantidade.getCafe()+" unidades.");
                ReposicaoFornecedor.reporItem(item);
                System.out.println("Estamos providenciando mais, é só aguardar!");
                System.out.println("...\nPronto!");
            }
            precoTotal = 9.56 * qtd;
            ItensPorQuantidade.setCafe((ItensPorQuantidade.getCafe() - qtd));
        }

        if ("sanduiche".equals(item)) {
            if (ItensPorQuantidade.getSanduiche()<qtd){
                System.out.println("Lamentamos, mas temos apenas "+ItensPorQuantidade.getSanduiche()+" unidades, desculpe o transtorno!");
                if (DataProjeto.cozinhaEmFuncionamento()){
                    ReposicaoCozinha.reporItem(item);
                    System.out.println("A cozinha já está preparando mais!");
                    System.out.println("...\nPronto!");
                }
            } else {
                precoTotal = 4.5 * qtd;
                ItensPorQuantidade.setSanduiche((ItensPorQuantidade.getSanduiche() - qtd));
            }
        }
        return precoTotal;
    }
}

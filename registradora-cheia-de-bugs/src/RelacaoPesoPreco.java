public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            if (ItensPorQuantidade.getPao()<qtd){
                System.out.println("Lamentamos, mas temos apenas "+ItensPorQuantidade.getPao()+" unidades, desculpe o transtorno!");
                precoTotal = 12.75 * (ItensPorQuantidade.getPao() * (double) 60 / (double) 1000);
                ItensPorQuantidade.setPao(0);
            } else{
                precoTotal = 12.75 * (qtd * (double) 60 / (double) 1000);
                ItensPorQuantidade.setPao((ItensPorQuantidade.getPao()-qtd));
            }
        }

        if ("torta".equals(item)) {
            if (ItensPorQuantidade.getTorta()<qtd){
                System.out.println("Lamentamos, mas temos apenas "+ItensPorQuantidade.getTorta()+" unidades, desculpe o transtorno!");
                precoTotal = 96.00 * ((double) ItensPorQuantidade.getTorta() / (double) 16);
                ItensPorQuantidade.setTorta(0);
            } else {
                precoTotal = 96.00 * ((double) qtd / (double) 16);
                ItensPorQuantidade.setTorta((ItensPorQuantidade.getTorta()-qtd));
            }
        }

        if ("leite".equals(item)) {
            if (ItensPorQuantidade.getLeite()<qtd){
                System.out.println("Lamentamos, mas temos apenas "+ItensPorQuantidade.getLeite()+" unidades, desculpe o transtorno!");
                precoTotal = 4.48 * ItensPorQuantidade.getLeite();
                ItensPorQuantidade.setLeite(0);
            } else {
                precoTotal = 4.48 * qtd;
                ItensPorQuantidade.setLeite((ItensPorQuantidade.getLeite()-qtd));
            }
        }

        if ("cafe".equals(item)) {
            if (ItensPorQuantidade.getCafe()<qtd){
                System.out.println("Lamentamos, mas temos apenas "+ItensPorQuantidade.getCafe()+" unidades, desculpe o transtorno!");
                precoTotal = 9.56 * ItensPorQuantidade.getCafe();
                ItensPorQuantidade.setCafe(0);
            } else{
                precoTotal = 9.56 * qtd;
                ItensPorQuantidade.setCafe((ItensPorQuantidade.getCafe()-qtd));
            }
        }

        if ("sanduiche".equals(item)) {
            if (ItensPorQuantidade.getSanduiche()<qtd){
                System.out.println("Lamentamos, mas temos apenas "+ItensPorQuantidade.getSanduiche()+" unidades, desculpe o transtorno!");
                precoTotal = 4.5 * ItensPorQuantidade.getSanduiche();
                ItensPorQuantidade.setSanduiche(0);
            } else{
                precoTotal = 4.5 * qtd;
                ItensPorQuantidade.setSanduiche((ItensPorQuantidade.getSanduiche()-qtd));
            }
        }

        return precoTotal;
    }
}

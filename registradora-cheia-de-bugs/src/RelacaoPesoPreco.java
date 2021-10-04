public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            precoTotal = 12.75 * (qtd * 60 / 1000);
            ItensPorQuantidade.setPao((ItensPorQuantidade.getPao()-qtd));
        }

        if ("torta".equals(item)) {
            precoTotal = 96.00 * ((double) qtd / (double) 16);
            ItensPorQuantidade.setTorta((ItensPorQuantidade.getTorta()-qtd));
        }

        if ("leite".equals(item)) {
            precoTotal = 4.48 * qtd;
            ItensPorQuantidade.setPao((ItensPorQuantidade.getPao()-qtd));
        }

        if ("cafe".equals(item)) {
            precoTotal = 9.56 * qtd;
            ItensPorQuantidade.setLeite((ItensPorQuantidade.getLeite()-qtd));
        }

        if ("sanduiche".equals(item)) {
            precoTotal = 4.5 * qtd;
            ItensPorQuantidade.setSanduiche((ItensPorQuantidade.getSanduiche()-qtd));
        }

        return precoTotal;
    }
}

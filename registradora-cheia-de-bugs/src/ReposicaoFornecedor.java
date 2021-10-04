import java.util.Random;

public class ReposicaoFornecedor {

    static void reporItem(String item) {
        Random random = new Random();

        if ("leite".equals(item)) {
            ItensPorQuantidade.setLeite(ItensPorQuantidade.getLeite() + random.nextInt(40) + 10);
        }

        if ("cafe".equals(item)) {
            ItensPorQuantidade.setCafe(ItensPorQuantidade.getCafe()+random.nextInt(40) + 10);
        }
    }
}

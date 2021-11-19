package br.com.cwi.reset.projeto1;
import java.util.List;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {
        int res = 0;

        for(int numero:numeros){
            res+=numero;
        }
        return res;
    }

    public int calcularMedia(List<Integer> numeros) {
        int media;
        media = somarLista(numeros)/numeros.size();
        return media;
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        int compara = 0;
        for (int numero:
             numeros) {
            if (numero>compara){
                compara = numero;
            }
        }
        return compara;
    }

    public String obterPalavraInvertida(String palavra) {
        String inverso = "";
        for(int i=(palavra.length()-1); i>=0;i--){
            inverso = inverso.concat(String.valueOf(palavra.charAt(i)));
        }
        return inverso;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        int aux;
        for (int i = 0; i<(numeros.size());i++){
            for (int y = 0; y<(numeros.size()-1);y++){
                if (numeros.get(y) > numeros.get(y + 1)) {
                    aux = numeros.get(y);
                    numeros.set(y, numeros.get(y+1));
                    numeros.set((y+1), aux);
                }
            }
        }
        return numeros;
    }


}


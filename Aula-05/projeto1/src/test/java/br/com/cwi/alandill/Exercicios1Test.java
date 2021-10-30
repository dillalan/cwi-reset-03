package br.com.cwi.alandill;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


public class Exercicios1Test {
    private final Exercicios1 exercicios1 = new Exercicios1();


    @Test
    public void somarCincoInteirosPositivos(){
        // Arrange
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        Integer esperado =5;

        // Action
        Integer obtido = exercicios1.somarLista(listaDeInteiros);

        // Assert
        Assertions.assertEquals(esperado,obtido);
    }

    @Test
    public void somarQuatroInteirosPositivosComUmInteiroNegativo(){
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(-1);
        Integer esperado = 3;

        Integer obtido = exercicios1.somarLista(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void somarTresElementosNegativos(){
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(-1);
        listaDeInteiros.add(-1);
        listaDeInteiros.add(-1);
        Integer esperado = -3;

        Integer obtido = exercicios1.somarLista(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void somarElementosZeros(){
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(0);
        listaDeInteiros.add(0);
        listaDeInteiros.add(0);
        Integer esperado = 0;

        Integer obtido = exercicios1.somarLista(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void somarListaVazia(){
        List<Integer> listaDeInteiros = new ArrayList<>();
        Integer esperado = 0;

        Integer obtido = exercicios1.somarLista(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void mediaSomarCincoInteirosPositivos(){
        // Arrange
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        Double esperado = 1.0;

        // Action
        Double obtido = exercicios1.calcularMedia(listaDeInteiros);

        // Assert
        Assertions.assertEquals(esperado,obtido);
    }

    @Test
    public void mediasomarQuatroInteirosPositivosComUmInteiroNegativo(){
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(-1);
        Double esperado = 0.6;

        Double obtido = exercicios1.calcularMedia(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void mediaSomarTresElementosNegativos(){
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(-1);
        listaDeInteiros.add(-1);
        listaDeInteiros.add(-1);
        Double esperado = -1.0;

        Double obtido = exercicios1.calcularMedia(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void mediaSomarElementosZeros(){
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(0);
        listaDeInteiros.add(0);
        listaDeInteiros.add(0);
        Double esperado = 0.0;

        Double obtido = exercicios1.calcularMedia(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void mediaSomarListaVazia(){
        List<Integer> listaDeInteiros = new ArrayList<>();
        Double esperado = 0.0;

        Double obtido = exercicios1.calcularMedia(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }


    @Test
    public void inverterAbacate(){
        String palavra = "Abacate";
        String esperado = "etacabA";

        String obtido = exercicios1.obterPalavraInvertida(palavra);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void inverterBanana(){
        String palavra = "Banana";
        String esperado = "ananaB";

        String obtido = exercicios1.obterPalavraInvertida(palavra);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void inverterPessego(){
        String palavra = "Pessego";
        String esperado = "ogesseP";

        String obtido = exercicios1.obterPalavraInvertida(palavra);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void inverterMorango(){
        String palavra = "Morango";
        String esperado = "ognaroM";

        String obtido = exercicios1.obterPalavraInvertida(palavra);

        Assertions.assertEquals(esperado, obtido);
    }

}

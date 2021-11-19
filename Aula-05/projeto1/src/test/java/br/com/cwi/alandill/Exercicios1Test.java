package br.com.cwi.alandill;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Exercicios1Test {
    private final Exercicios1 exercicios1 = new Exercicios1();


    @Test
    public void somarCincoInteirosPositivos() {
        // Arrange
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        listaDeInteiros.add(1);
        Integer esperado = 5;

        // Action
        Integer obtido = exercicios1.somarLista(listaDeInteiros);

        // Assert
        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void somarQuatroInteirosPositivosComUmInteiroNegativo() {
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
    public void somarTresElementosNegativos() {
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(-1);
        listaDeInteiros.add(-1);
        listaDeInteiros.add(-1);
        Integer esperado = -3;

        Integer obtido = exercicios1.somarLista(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void somarElementosZeros() {
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(0);
        listaDeInteiros.add(0);
        listaDeInteiros.add(0);
        Integer esperado = 0;

        Integer obtido = exercicios1.somarLista(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void somarListaVazia() {
        List<Integer> listaDeInteiros = new ArrayList<>();
        Integer esperado = 0;

        Integer obtido = exercicios1.somarLista(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void mediaSomarCincoInteirosPositivos() {
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
        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void mediasomarQuatroInteirosPositivosComUmInteiroNegativo() {
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
    public void mediaSomarTresElementosNegativos() {
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(-1);
        listaDeInteiros.add(-1);
        listaDeInteiros.add(-1);
        Double esperado = -1.0;

        Double obtido = exercicios1.calcularMedia(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void mediaSomarElementosZeros() {
        List<Integer> listaDeInteiros = new ArrayList<>();
        listaDeInteiros.add(0);
        listaDeInteiros.add(0);
        listaDeInteiros.add(0);
        Double esperado = 0.0;

        Double obtido = exercicios1.calcularMedia(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void mediaSomarListaVazia() {
        List<Integer> listaDeInteiros = new ArrayList<>();
        Double esperado = 0.0;

        Double obtido = exercicios1.calcularMedia(listaDeInteiros);

        Assertions.assertEquals(esperado, obtido);
    }


    @Test
    public void inverterAbacate() {
        String palavra = "Abacate";
        String esperado = "etacabA";

        String obtido = exercicios1.obterPalavraInvertida(palavra);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void inverterBanana() {
        String palavra = "Banana";
        String esperado = "ananaB";

        String obtido = exercicios1.obterPalavraInvertida(palavra);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void inverterPessego() {
        String palavra = "Pessego";
        String esperado = "ogesseP";

        String obtido = exercicios1.obterPalavraInvertida(palavra);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void inverterMorango() {
        String palavra = "Morango";
        String esperado = "ognaroM";

        String obtido = exercicios1.obterPalavraInvertida(palavra);

        Assertions.assertEquals(esperado, obtido);
    }

    @Test
    public void testarBubleSort(){
        // Arrange
        List<Integer> listaDesordenada = new ArrayList<>();
        listaDesordenada.add(3);
        listaDesordenada.add(4);
        listaDesordenada.add(5);
        listaDesordenada.add(2);
        listaDesordenada.add(1);

        List<Integer> listaOrdenada = new ArrayList<>();
        listaOrdenada.add(1);
        listaOrdenada.add(2);
        listaOrdenada.add(3);
        listaOrdenada.add(4);
        listaOrdenada.add(5);

        // Action
        for (int i = 0; i < 5; i++) {
            Integer obtido = exercicios1.ordenarLista(listaDesordenada).get(i);

            // Assert
            Assertions.assertEquals(listaOrdenada.get(i), obtido);
        }
    }

    @Test
    public void testOrdenamento(){
        List<Integer> listaDesordenada = Arrays.asList(-5, -4, -3, -1, -2);
        List<Integer> listaEsperada = Arrays.asList(-5, -4, -3, -2, -1);

        List<Integer> listaObtida = exercicios1.ordenarLista(listaDesordenada);

        Assertions.assertEquals(listaEsperada, listaObtida);




    }

}

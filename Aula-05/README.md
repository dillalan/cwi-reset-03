# Testes Unitários | Reset Aula Extra

Assign: Anonymous
Priority: High 🔥
Status: Completed
Tags: Unit Test

# Testes Unitários

---

Entender bem como aplicar testes unitários é uma das skills mais preciosas para um bom engenheiro de software. Eles não somente ajudam a garantir a integridade e o funcionamento adequado do nosso código, mas ainda nos ajudam a escrever um código cada vez melhor. 

Para implementar testes unitários devemos seguir algumas regras básicas que serão aqui explicadas, e será nítidos os benefícios que tais regras irão gerar para nossa implementação.

## O que são ?

- São métodos que instanciam uma **pequena parte** do nosso código com o intuito de verificar se ele **está fazendo o que se propõe a fazer**.
- Idealmente ele é separado em três fases:
    1. Ele **inicializa** uma pequena parte do nosso código e **monta o cenário a ser validado (Arrange)**
    2. Aplica o **estímulo** a parte do código que queremos testar, ou seja, **executa a ação. (Action)**
    3. **Observa** o resultado gerado e **valida** se está **de acordo com o resultado esperado (Assert)**
- Os passos acima descrevem o famoso conceito [Triple AAA](https://freecontent.manning.com/making-better-unit-tests-part-1-the-aaa-pattern/)

## Podemos separar os testes unitários em tipos ?

Sim, na maioria dos casos os testes unitários podem ser distinguidos em dois tipos.

**Baseado em estado:** Neste caso estamos interessados se dado um determinado input o retorno está de acordo com o esperado, e quais foram os efeitos dessa ação no estado da aplicação.

**Baseado em Interações:** Nesse caso estamos interessados se dado um cenário de teste as interações com as classes vizinhas foram realizadas conforme o esperado. 

## Testes Unitários vs Integração

É preciso entender as diferenças entre estes dos tipos de testes para realmente produzir testes unitários de valor. Um teste de unidade, como seu nome pressupõe, tem a intenção de testar uma pequena parte da implementação da nossa aplicação. Na maioria das vezes, apenas um **método.**

É importante entender também, que para testar apenas uma pequena parte do nosso código, é necessário que tenhamos o menor acoplamento possível com nossas integrações, por conta disso, **o conceito de Mocks é tão relevante.**

Já nos testes de integração, estamos interessados em testar o todo da nossa aplicação, ou seja, um conjunto de classes, uma interface disponível para o usuário, um endpoint RESTFULL, etc.

## Como escrever bons Testes Unitários ?

Algumas características importantes compõem um bom teste unitário, são elas:

- **Simplicidade e facilidade de escrita:** Bons desenvolvedores codificam uma quantidade enorme de testes unitários diariamente, para isso, eles precisam ser pequenos e simples. Para tal, nosso código também precisa ser implementado para propiciar essa facilidade.
- **Precisam ser rápidos:** Testes unitários precisam executar de forma rápida. A cada pequeno incremento no código deve ser possível executar toda rotina de testes unitários em poucos segundos.
- **São os donos da verdade:** Nossos testes não devem mentir, são eles os donos da verdade quanto a eficiência e coerência do nosso código. Só devem falhar se tivermos alguma quebra/bug em nosso código.
- **Fácil Leitura e evolução:** Nossos testes precisam ser bem escritos, afinal código de testes deve ser mantido da mesma forma com que a implementação das funcionalidades. Dar manutenção na bateria de testes deve ser simples.

## Chega de conversa, bora pro código:

No nosso exemplo, iremos implementar testes unitários em Java. Para tal, faremos uso de duas libs bastante populares no mundo java: JUnit e Mockito.

---

## JUnit

É um framework open-source que nos apoia na escrita de testes unitários para a linguagem Java. Ele nos fornece várias facilitações para a escrita das nossas classes de teste, é o que veremos a seguir.

Primeiro passo: Adicionar a dependência do Junit ao pom do projeto, conforme abaixo:

```xml
<dependency>
<groupId>org.junit.jupiter</groupId>
<artifactId>junit-jupiter-api</artifactId>
<version>5.7.2</version>
<scope>test</scope>
</dependency>
```

### Anotações providas pelo JUnit e bastante utilizadas

@`Test` : Utilizado nos nossos métodos de teste para dizer para o JUnit que este é um cenário a ser testado e deve rodar em nossa switch de testes.

`@BeforeEach` e `AfterEach`: Diz que um dado método deve ser executado antes/depois da execução de cada um dos testes de uma dada classe.

### Principais classes e métodos

1. Assertions: Possui uma série de métodos para nos ajudar na etapa de Assertion (validações dos nossos testes). Exemplos de métodos: assertEquals, assertNotEquals, assertTrue, assertFalse dentre vários outros.

### Exemplo de um método de Teste

```java
@Test
public void testSomarComUmInteiroEOutroNegativoResultadoNegativo() {
    // Arrange
    CalculadoraService service = new CalculadoraService();
    Double primeiroNumero = 10.0;
    Double segundoNumero = -20.0;
    Double expected = -10.0;

    // Action
    Double result = service.somar(primeiroNumero, segundoNumero);

    // Assert
    Assertions.assertEquals(expected, result);
}
```

---

## Exercício 1

Agora vamos voltar um pouco ao passado, e escrever testes para os exercícios que desenvolvemos lá na AULA 1.

Na primeira aula praticamos bastante nossa lógica de programação, e escrevemos alguns métodos interessantes para praticarmos os novos conhecimentos a respeito de testes unitários. Nós até liberamos para a turma um método main com alguns cenários para testar as implementações desenvolvidas pela turma, vamos agora transformar isso em um conjunto de testes automatizados do JUnit, portando vamos seguir as etapas abaixo.

1. Criar uma classe chamada Exercicios1Test dentro da nossa pasta de testes. Lembrando que a classe deve estar em um pacote com o mesmo nome onde nossa implementação está. 
2. Criar os seguintes cenários/métodos para testar o método que soma os números contidos em uma Lista.
    1. Validar a soma com uma lista de 5 números inteiros e positivos.
    2. Validar a soma com uma lista com 5 elementos, 4 inteiros e 1 negativo
    3. Validar a soma com uma lista com 3 elementos negativos
    4. Validar a soma com uma lista contendo todos elementos como ZERO
    5. Validar a soma com uma lista vazia (sem nenhum valor dentro)
3. Para exatamente os mesmos cenários descritos acima, realizar o teste do método que calcula a média de uma lista.
4. Testar o método que inverte uma palavra passando as seguintes palavras.
    1. Abacate
    2. Banana
    3. Pessego
    4. Morango

---

### Validar exceções lançadas

```java
@Test
void exceptionTesting() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        throw new IllegalArgumentException("a message");
    });
    assertEquals("a message", exception.getMessage());
}
```

---

## Artigos e leituras recomendadas:

**Tipos de testes:** [https://www.linkedin.com/pulse/principais-tipos-de-teste-software-marcus-dratovsky/](https://www.linkedin.com/pulse/principais-tipos-de-teste-software-marcus-dratovsky/)

**Pirâmide de testes:** [https://medium.com/@gianegf/pirâmide-de-testes-uma-boa-estratégia-para-automação-de-testes-na-prática-1d87e64c3a44](https://medium.com/@gianegf/pir%C3%A2mide-de-testes-uma-boa-estrat%C3%A9gia-para-automa%C3%A7%C3%A3o-de-testes-na-pr%C3%A1tica-1d87e64c3a44)

**Tutorial de JUnit (principal biblioteca de testes para Java):** [https://www.devmedia.com.br/junit-tutorial/1432](https://www.devmedia.com.br/junit-tutorial/1432)

**Conceitos Básicos sobre Mockito:** [https://inside.contabilizei.com.br/conceitos-basicos-sobre-mockito-73b931ce0c2c?gi=8b46ff704dae](https://inside.contabilizei.com.br/conceitos-basicos-sobre-mockito-73b931ce0c2c?gi=8b46ff704dae)

**Mais um tutorial sobre Mockito (porque não é fácil kkk):** [https://www.vogella.com/tutorials/Mockito/article.html](https://www.vogella.com/tutorials/Mockito/article.html)

**Falei que era difícil, então bora de outro sobre Mockito e Mocks:** [http://www.codeatest.com/mockito-isolamento-testes-unidade/](http://www.codeatest.com/mockito-isolamento-testes-unidade/)

**E mais um só pra fixar bem:** [https://casadelkrogh.dk/2014/10/mockito-cheat-sheet/](https://casadelkrogh.dk/2014/10/mockito-cheat-sheet/)

**E pra fechar, material do Mestre Neto sobre boas práticas na implementação de testes unitários:** [https://github.com/AlexandreSNeto/testes-com-mockito](https://github.com/AlexandreSNeto/testes-com-mockito)

material complementar para testes parametrizados: 

1 - Implementar testes para soma, divisão e subtração
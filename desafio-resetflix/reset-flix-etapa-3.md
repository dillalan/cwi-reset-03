# Desafio resetflix - Parte 3

## Transformando nossa aplicação em aplicação Web em camadas com Banco de Dados

Reseters, esta é a nossa última semana de desafio, vamos refatorar algumas coisas do projeto para termos uma arquitetura em camadas, e poder incluir a camada para integração com o nosso banco de dados (vamos finalmente remover a classe FakeDatabase do nosso projeto :partying_face:).

Para começarmos, vamos precisar ajustar nosso pom.xml para adicionarmos nossa dependência do framework do Spring Boot, para fazermos isso vamos acessar a URL so Spring Initializr (encontrada neste link: https://start.spring.io/) e vamos selecionar as seguintes opções (elas podem diferenciar em nome dependendo das configurações de linguagem do seu browser):

- Project -> Maven Project
- Language -> Java
- Spring Boot -> 2.5.5
- Project Metadata:
    - Group -> br.com.cwi.reset.{seunomeaqui}
    - Artifact -> api-resetflix
    - Name -> api-resetflix
    - Description -> {Não é necessário, pode colocar o que desejar}
    - Package name -> br.com.cwi.reset.{seunomeaqui}
- Packaging -> Jar
- Java -> 8

E nas dependências vamos selecionar a dependência do `Spring Web`, `Validation`, `Spring Data JPA ` e `H2 Database`

---

Após incluído todas as informações conforme acima vamos clicar no botão "Explore" que é apresentado no browser, e na tela que abrir, vamos procurar o arquivo pom.xml, e vamos substituir o arquivo existente do nosso projeto, com o arquivo gerado pelo site.

Segue um exemplo de como era nosso pom.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>br.com.cwi.reset.josealencar</groupId>
	<artifactId>api-resetflix</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>api-resetflix</name>
	<properties>
		<java.version>1.8</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```

E como deve ficar agora o nosso pom.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.6</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>br.com.cwi.reset.josealencar</groupId>
	<artifactId>api-resetflix</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>api-resetflix</name>
	<properties>
		<java.version>1.8</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

```

---

Nosso último passo será configurar o `application.properties` da nossa aplicação para referenciarmos o nosso banco de dados, para isto vamos alterar o conteúdo do arquivo adicionando algumas linhas a mais:

Como era:

```
server.error.include-message=always
server.error.include-binding-errors=always
```

Como Fica:

```
server.error.include-message=always
server.error.include-binding-errors=always

spring.datasource.url=jdbc:h2:file:~/resetflix
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true
```

> Após iniciar a nossa aplicação, é possível acessar uma interface visual do nosso banco acessando o link http://localhost:8080/h2-console no browser e ajustando o formulário no campo JDBC URL para o valor `jdbc:h2:file:~/resetflix`

> ***IMPORTANTE***: É necessário rodar a nossa aplicação para poder acessar o banco, caso contrário o mesmo não estará disponível

Projeto configurado, vamos ao nosso desafio semanal!!!

---

## Acabou a moleza :fire:

Para esta semana vamos definir alguns objetivos para vocês, e quais são eles:

- Estrutura em camandas (controller, service, repository)
    - A aplicação pode conter mais pacotes além destes comentados para melhor organização de código
- Injeção de dependências
- Validações com Bean Validations: https://beanvalidation.org/2.0/spec/#builtinconstraints
    - Esta arquitetura permite adicionar camadas de validações na nossa estrutura de dados através de anotações
    - Exemplo: se quero validar o campo nome como não nulo da classe AtorRequest, basta eu incluir a anotação `@NotNull` no campo nome da classe
    - **IMPORTANTE**: para que sejam aplicados as validações através do Bean Validations é necessário anotar o parâmetro na controller para `@Valid`

Acordos feitos, vamos ao nosso desafio, para auxiliar vocês um pouco no processo já estou apresentando um "passo a passo" recomendado para vocês organizarem as atividades e estruturarem o projeto.

---

### Adicionar o mapeamento das entidades e criar a camada repository

Para esta etapa vamos disponibilizar as entidades mapeadas, para isto basta acessar a seguinte pasta e copiar todo o conteúdo para o projeto de vocês:

- https://github.com/cwi-reset/edicao-03-level-2/tree/master/desafio-resetflix/api-resetflix/src/main/java/br/com/cwi/reset/josealencar/model

PS.: São as mesmas classes de modelo solicitadas nos exercícios anteriores, apenas com as anotações de integração com o banco, e devem substituir as classes criadas por vocês.

Após isto basta criar as classes de repository para cada uma das entidades.

---

### Refatorar projeto para estrutura em camadas

Na refatoração para estrutura em camadas, nós vamos basicamente separar as responsabilidades da nossa aplicação nas seguintes estruturas básicas:

- Controller: Camada responsável por nossos contratos Rest
- Service: Camada responsável por nossa lógica de negócio
- Repository: Camada responsável pela integração com nosso banco de dados

---

### Injeção de dependências

Na refatoração para injeção de dependências vamos incluir a nossa nova camada de repository em nossas services, e ajustar os nossos métodos para utilizar as classes de repository, após esta etapa poderemos remover a classe `FakeDatabase` do nosso projeto

---

### Bean Validations

Na refatoração para incluir o uso do Bean Validations no projeto será possível refatorar os métodos das services para remover as validações que agora serão de responsabilidade do Bean Validations

---

## Inclusão de novos comportamentos

Para termos um conteúdo mais completo, vamos adicionar as rotinas de atualização e remoção, vamos as definições.

### 1. Elenco

#### 1.5. Atualizar ator

- Assinatura
    - `PUT /atores/{id}`
- Contrato
    - Classe: AtorController | Retorno: void | Método: atualizarAtor(Integer id, AtorRequest atorRequest)
- Parâmetros de entrada:
    - id* (path variable)
    - AtorRequest* (body)
        - nome*
        - dataNascimento*
        - StatusCarreira statusCarreira*
            - EM_ATIVIDADE
            - APOSENTADO
        - anoInicioAtividade*
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body: `N/A`
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Campos com * são campos obrigatórios
        - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
    - Caso não encontrado o Ator para o id informado, deve retornar erro: 
        - Mensagem de erro: "Nenhum ator encontrado com o parâmetro id={campo}, favor verifique os parâmetros informados."
    - Não deve ser permitido cadastrar dois atores com o mesmo nome
        - Mensagem de erro: "Já existe um ator cadastrado para o nome {nome}."

#### 1.6. Remover ator

- Assinatura
    - `DELETE /atores/{id}`
- Contrato
    - Classe: AtorController | Retorno: void | Método: removerAtor(Integer id)
- Parâmetros de entrada:
    - id (path variable)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body: `N/A`
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - O filtro id é obrigatório
        - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
    - Caso não encontrado o Ator para o id informado, deve retornar erro: 
        - Mensagem de erro: "Nenhum ator encontrado com o parâmetro id={campo}, favor verifique os parâmetros informados."
    - Não é permitido remover atores que estão vinculados a um personagem ator, caso o ator esteja vinculado a um papel deve retornar erro
        - Mensagem de erro: "Este ator está vinculado a um ou mais personagens, para remover o ator é necessário remover os seus personagens de atuação."

### 2. Direção

#### 2.4. Atualizar diretor

- Assinatura
    - `PUT /diretores/{id}`
- Contrato
    - Classe: DiretorController | Retorno: void | atualizarDiretor(Integer id, DiretorRequest diretorRequest)
- Parâmetros de entrada:
    - id* (path variable)
    - DiretorRequest* (body)
        - nome*
        - dataNascimento*
        - anoInicioAtividade*
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body: `N/A`
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Campos com * são campos obrigatórios
        - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
    - Caso não encontrado o diretor, deve retornar erro
        - Mensagem de erro: "Nenhum diretor encontrado com o parâmetro id={}, favor verifique os parâmetros informados."
    - Não deve ser permitido cadastrar dois diretores com o mesmo nome
        - Mensagem de erro: "Já existe um diretor cadastrado para o nome {nome}."

#### 2.5. Remover diretores

- Assinatura
    - `DELETE /diretores/{id}`
- Contrato
    - Classe: DiretorController | Retorno: void | removerDiretores(Integer id)
- Parâmetros de entrada:
    - id (path variable)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body: `N/A`
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - O filtro id é obrigatório
        - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
    - Caso não encontrado o diretor, deve retornar erro
        - Mensagem de erro: "Nenhum diretor encontrado com o parâmetro id={}, favor verifique os parâmetros informados."
    - Não é permitido remover diretores que estão vinculados a um ou mais filmes, caso o diretor esteja vinculado a filmes deve retornar erro
        - Mensagem de erro: "Este diretor está vinculado a um ou mais filmes, para remover o diretor é necessário remover os seus filmes de participação."

### 4. Filmes

#### 4.3. Remover Filmes

- Assinatura
    - `DELETE /filmes/{id}`
- Contrato
    - Classe: FilmeController | Retorno: void | Método: removerFilme(Integer id)
- Parâmetros de entrada:
    - id (path variable)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body: `N/A`
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - O filtro id é obrigatório
        - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
    - Caso não encontrado o filme, deve retornar erro
        - Mensagem de erro: "Nenhum filme encontrado com o parâmetro id={}, favor verifique os parâmetros informados."
    - Deve ser removido apenas o filme e seus personagens vinculados

package br.com.cwi.reset.alandill;

import br.com.cwi.reset.alandill.exception.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aplicacao {
    public static void main(String[] args) throws NaoEncontradoException, SemCadastroException,
            NomeException, TemporalException, ObrigatorioException {

        SpringApplication.run(Aplicacao.class, args);

    }
}

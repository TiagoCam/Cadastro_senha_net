package br.com.cadastros;

import br.com.cadastros.model.entity.Cadastro;
import br.com.cadastros.model.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CadastrosAplication {

    @Bean
    public CommandLineRunner run(@Autowired CadastroRepository repository) {
        return args -> {
            Cadastro cadastro1 = Cadastro.builder().nomeGerente("Tiago").nomeColaborador("Rubens").senha("94631658").build();
            Cadastro cadastro2 = Cadastro.builder().nomeGerente("David").nomeColaborador("Eduardo").senha("52452444").build();
            Cadastro cadastro3 = Cadastro.builder().nomeGerente("Nadia").nomeColaborador("Maria").senha("42452537").build();

            repository.save(cadastro1);
            repository.save(cadastro2);
            repository.save(cadastro3);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CadastrosAplication.class, args);
    }
}

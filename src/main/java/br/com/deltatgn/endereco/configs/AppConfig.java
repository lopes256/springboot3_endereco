package br.com.deltatgn.endereco.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Jammerson
 */
@Configuration
public class AppConfig {

    @Value(value = "${APPLICATION.AMBIENTE}")
    private String ambiente;

    @Bean
    public CommandLineRunner execulteAppConfig() {
        return args -> {
            System.out.println("=============================================================");
            System.out.println("Ambiente: " + ambiente);
            System.out.println("=============================================================");
        };
    }

}

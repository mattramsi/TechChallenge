package com.techchallengev2.app.config;

import com.techchallengev2.app.models.Categoria;
import com.techchallengev2.app.models.Status;
import com.techchallengev2.app.repositories.CategoriaRepository;
import com.techchallengev2.app.repositories.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class DataLoader {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Bean
    CommandLineRunner initDatabase(CategoriaRepository categoriaRepository) {
        return args -> {
            logger.info("DataLoader está executando...");
            List<String> categoriasIniciais = List.of("Lanche", "Acompanhamento", "Bebida", "Sobremesa");
            categoriasIniciais.forEach(nome -> {
                if (categoriaRepository.findByNome(nome).isEmpty()) {
                    categoriaRepository.save(new Categoria(nome));
                    logger.info("Categoria '{}' salva no banco de dados.", nome);
                }
            });
        };
    }

    @Bean
    CommandLineRunner initStatusDatabase(StatusRepository statusRepository) {
        return args -> {
            List<String> statusIniciais = List.of("Recebido", "Em preparação", "Pronto", "Finalizado");
            statusIniciais.forEach(nome -> {
                if (statusRepository.findByNome(nome).isEmpty()) {
                    statusRepository.save(new Status(nome));
                    System.out.println("Status '" + nome + "' salvo no banco de dados.");
                }
            });
        };
    }
}
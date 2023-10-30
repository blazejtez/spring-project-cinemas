package pl.edu.pg.menu.caffemenu.service;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import pl.edu.pg.menu.caffemenu.entity.Menu;

@Service
public class DataInitializer {

    @Bean
    @PostConstruct
    public CommandLineRunner createData(MenuRepository menuRepository) {

    }
}

package pl.edu.pg.menu.caffemenu;
import org.springframework.beans.factory.DisposableBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.service.MenuService;

import java.util.TreeSet;

@SpringBootApplication
public class CaffeMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaffeMenuApplication.class, args);

	}
}

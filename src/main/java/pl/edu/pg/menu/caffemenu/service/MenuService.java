package pl.edu.pg.menu.caffemenu.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.repository.MenuRepository;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Stream<Dish> getAllElementsFromAllCategories() {
        return menuRepository.findAll().stream()
                .flatMap(menu -> menu.getDishes().stream());
    }
    public void printAllElements(Set<Dish> allElements) {
        menuRepository.findAll().stream()
                .flatMap(menu -> menu.getDishes().stream())
                .collect(Collectors.toSet()).forEach(dish -> System.out.println(dish));
    }
    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("Nested Lambdas:\n");
        this.menuRepository.findAll().forEach((menu) -> {
            System.out.println(menu);
            menu.getDishes().forEach(
                    (dish) -> {
                        System.out.println("Dish: " + dish.getId() + " " + dish.getName()+ " "  + dish.getPrice()+ " " + "\n");
                    });
            });

        }
    }

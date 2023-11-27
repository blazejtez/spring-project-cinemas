package pl.edu.pg.menu.caffemenu.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.menu.caffemenu.dto.DishDTO;
import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.repository.MenuRepository;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
        TreeSet<Dish> allDishes = new TreeSet<Dish>();
        menuRepository.findAll().forEach(menu -> {
            allDishes.addAll(menu.getDishes());
        });
        return allDishes.stream();
    }
    public void printAllElements(Set<Dish> allElements) {
        menuRepository.findAll().stream()
                .forEach((menu) -> {
                    System.out.println(menu);
                    menu.getDishes().forEach(
                        (dish) -> {
                            System.out.println(dish);
                        });
        });
    }
    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("Lab1-2: Nested Lambdas:\n");
        this.menuRepository.findAll().forEach((menu) -> {
            System.out.println(menu);
            menu.getDishes().forEach(
                    (dish) -> {
                        System.out.println(dish);
                    });
        });
        //lab1-3
        System.out.println("Pipeline printing - Lab1-3:\n");
        List<Dish> allItemsList = getAllElementsFromAllCategories().toList();
        Set<Dish> allItemsSet = new TreeSet<Dish>(allItemsList);
        printAllElements(allItemsSet);

        //lab1-4
        System.out.println("Filter elements collection by name, sorting it by price ascending, and printing it");
        List<Dish> filteredItems = allItemsSet
                .stream()
                .filter(item -> item.getName().contains("Muffin"))
                .sorted()
                .toList();
        System.out.println(filteredItems);

        //lab1-5
        System.out.println("Transform elements collection created earlier into stream of DTO objects," +
                " sort using natural order (by price) and collect into List, then print it");
        List<DishDTO> dishDTOS = getAllElementsFromAllCategories()
                .map(DishDTO::fromEntity)
                .sorted(Comparator.comparing(DishDTO::getPrice))
                .toList();
        dishDTOS.stream().forEach(dishDTO -> {
            System.out.println(dishDTO);
        }

        //lab1-6


        );
    }
}

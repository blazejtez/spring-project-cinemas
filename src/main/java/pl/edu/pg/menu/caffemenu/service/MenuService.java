package pl.edu.pg.menu.caffemenu.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.menu.caffemenu.dto.DishDTO;
import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.entity.Menu;
import pl.edu.pg.menu.caffemenu.repository.MenuRepository;

import java.io.*;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;
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
        Set<Dish> allItemsSet = new TreeSet<>(allItemsList);
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
        });

        //lab1-6
        System.out.println("Serialize and Deserialize");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("menus.bin"))) {
            outputStream.writeObject(menuRepository.findAll());
            System.out.println("Menus serialized and stored in 'menus.bin'");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("menus.bin"))) {
            TreeSet<Menu> menus = (TreeSet<Menu>) inputStream.readObject();

            // Printing categories with their elements
            for (Menu menu : menus) {
                menu.getDishes().forEach(
                        (dish) -> dish.setMenu(menu)
                );
                System.out.println(menu);
                menu.getDishes().forEach(
                        (dish) -> {
                            System.out.println(dish);
                        });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            TreeSet<Menu> menus = menuRepository.findAll();
            ForkJoinPool customThreadPool = new ForkJoinPool(3);
            customThreadPool.submit(
                    () -> menus.parallelStream().forEach(dish ->
                    {
                        try {
                            Thread.sleep((int)(Math.random()*10000));
                            System.out.println(dish.toString() + " " + Thread.currentThread().getName());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }));

            customThreadPool.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}

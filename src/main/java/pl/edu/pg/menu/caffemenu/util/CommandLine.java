package pl.edu.pg.menu.caffemenu.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.entity.Menu;
import pl.edu.pg.menu.caffemenu.service.DishService;
import pl.edu.pg.menu.caffemenu.service.MenuService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Component
public class CommandLine implements CommandLineRunner {

    private final DishService dishService;
    private final MenuService menuService;

    public CommandLine(DishService dishService, MenuService menuService) {
        this.dishService = dishService;
        this.menuService = menuService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while(true)
        {
            System.out.println("Available commands:");
            System.out.println("1. list_menus");
            System.out.println("2. list_dishes");
            System.out.println("3. add_dish");
            System.out.println("4. delete_dish");
            System.out.println("5. quit");
            System.out.print("Enter command: ");
            command = scanner.next();
            switch (command) {
                case "list_menus" -> {
                    List<Menu> response = this.menuService.findAll();
                    response.forEach(System.out::println);
                }
                case "list_dishes" -> {
                    List<Dish> response = this.dishService.findAll();
                    response.forEach(System.out::println);
                }
                case "add_dish" -> {
                    System.out.print("Enter dish UUID: ");
                    UUID uuid = null;
                    try
                    {
                        uuid = UUID.fromString(scanner.next());
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println("Wrong UUID");
                        continue;
                    }
                    System.out.print("Enter dish name: ");
                    String name = scanner.next();
                    System.out.print("Enter dish price: ");
                    BigDecimal price;
                    try
                    {
                        price = new BigDecimal(scanner.next());
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Wrong number");
                        continue;
                    }
                    System.out.print("Enter menu UUID: ");
                    UUID menuUuid;
                    try
                    {
                        menuUuid = UUID.fromString(scanner.next());
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println("Wrong Menu UUID");
                        continue;
                    }

                    Menu menu = this.menuService.findById(menuUuid);
                    Dish dish = Dish.builder()
                            .id(uuid)
                            .name(name)
                            .price(price)
                            .menu(menu)
                            .build();
                    try {
                        this.dishService.create(dish);;
                    } catch (Exception e) {
                        System.out.println("Bad Request");
                    }

                }
                case "delete_dish" -> {
                    System.out.println("Enter dish UUID");
                    String uuid = scanner.next();
                    this.dishService.delete(UUID.fromString(uuid));
                }
                case "quit" -> {
                    break main_loop;
                }
            }

        }

    }
}

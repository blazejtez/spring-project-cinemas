package pl.edu.pg.menu.caffemenu.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.entity.Menu;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.TreeSet;

@Repository
public class MenuRepository {
    TreeSet<Menu> menuList = new TreeSet<Menu>();

    @PostConstruct
    public void init() {
        Menu secondBreakfastMenu = Menu.builder()
                .name("Second Breakfast")
                .startDate(LocalDate.of(2023, 5, 1))
                .endDate(LocalDate.of(2023, 6, 7))
                .dishes(List.of(
                        Dish.builder()
                                .id(Long.parseLong("1"))
                                .name("Chocolate Muffin")
                                .price(new BigDecimal("4.99"))
                                .build(),
                        Dish.builder()
                                .id(Long.parseLong("2"))
                                .name("Vanilla Muffin")
                                .price(new BigDecimal("3.99"))
                                .build(),
                        Dish.builder()
                                .id(Long.parseLong("3"))
                                .name("Pumpkin Spice Muffin")
                                .price(new BigDecimal("7.99"))
                                .build(),

                        Dish.builder()
                                .id(Long.parseLong("4"))
                                .name("Fruit Salad")
                                .price(new BigDecimal("7.99"))
                                .build()
                ))
                .build();
        secondBreakfastMenu.getDishes().forEach(dish -> {dish.setMenu(secondBreakfastMenu);});
        menuList.add(secondBreakfastMenu);

        Menu dinnerMenu = Menu.builder()
                .name("Dinner")
                .startDate(LocalDate.of(2023, 2, 1))
                .endDate(LocalDate.of(2023, 12, 7))
                .dishes(List.of(
                        Dish.builder()
                                .id(Long.parseLong("5"))
                                .name("Steak")
                                .price(new BigDecimal("15.99"))
                                .build(),
                        Dish.builder()
                                .id(Long.parseLong("6"))
                                .name("Pasta")
                                .price(new BigDecimal("12.99"))
                                .build()
                ))
                .build();
        dinnerMenu.getDishes().forEach(dish -> {dish.setMenu(dinnerMenu);});
        menuList.add(dinnerMenu);

        Menu supperMenu = Menu.builder()
                .name("Supper")
                .startDate(LocalDate.of(2023, 10, 1))
                .endDate(LocalDate.of(2023, 11, 7))
                .dishes(List.of(
                        Dish.builder()
                                .id(Long.parseLong("7"))
                                .name("Soup")
                                .price(new BigDecimal("6.99"))
                                .build(),
                        Dish.builder()
                                .id(Long.parseLong("8"))
                                .name("Chicken")
                                .price(new BigDecimal("11.99"))
                                .build()
                ))
                .build();
        supperMenu.getDishes().forEach(dish -> {dish.setMenu(supperMenu);});
        menuList.add(supperMenu);

    }

    public void create(Menu menu) {
        this.menuList.add(menu);
    }

    public TreeSet<Menu> findAll() {
        return this.menuList;
    }

    public void remove(Menu menu) {

    }

    public void update() {

    }

}

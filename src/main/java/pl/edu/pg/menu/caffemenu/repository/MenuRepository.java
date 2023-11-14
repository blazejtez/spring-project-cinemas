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
                .startDate(LocalDate.of(2023, 05, 1))
                .endDate(LocalDate.of(2023, 06, 7))
                .dishes(List.of(
                        Dish.builder()
                                .name("Muffin")
                                .price(new BigDecimal("4.99"))
                                .build(),
                        Dish.builder()
                                .name("Fruit Salad")
                                .price(new BigDecimal("7.99"))
                                .build()
                ))
                .build();
        menuList.add(secondBreakfastMenu);

        Menu dinnerMenu = Menu.builder()
                .name("Dinner")
                .startDate(LocalDate.of(2023, 2, 1))
                .endDate(LocalDate.of(2023, 12, 7))
                .dishes(List.of(
                        Dish.builder()
                                .name("Steak")
                                .price(new BigDecimal("15.99"))
                                .build(),
                        Dish.builder()
                                .name("Pasta")
                                .price(new BigDecimal("12.99"))
                                .build()
                ))
                .build();
        menuList.add(dinnerMenu);

        Menu supperMenu = Menu.builder()
                .name("Supper")
                .startDate(LocalDate.of(2023, 10, 1))
                .endDate(LocalDate.of(2023, 11, 7))
                .dishes(List.of(
                        Dish.builder()
                                .name("Soup")
                                .price(new BigDecimal("6.99"))
                                .build(),
                        Dish.builder()
                                .name("Chicken")
                                .price(new BigDecimal("11.99"))
                                .build()
                ))
                .build();
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

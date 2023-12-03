package pl.edu.pg.menu.caffemenu.util;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.entity.Menu;
import pl.edu.pg.menu.caffemenu.service.DishService;
import pl.edu.pg.menu.caffemenu.service.MenuService;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
public class DataInitializer implements InitializingBean {
    private final DishService dishService;
    private final MenuService menuService;
    @Autowired
    public DataInitializer(DishService dishService, MenuService menuService) {
        this.dishService = dishService;
        this.menuService = menuService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Menu secondBreakfastMenu = Menu.builder()
                .id(UUID.fromString("47a9767c-9203-11ee-b9d1-0242ac120002"))
                .name("Second Breakfast")
                .startDate(LocalDate.of(2023, 5, 1))
                .endDate(LocalDate.of(2023, 6, 7))
                .dishes(List.of(

                ))
                .build();
        menuService.create(secondBreakfastMenu);

        Dish chocolateMuffin = Dish.builder()
                .id(UUID.fromString("364f31e0-91ff-11ee-b9d1-0242ac120002"))
                .name("Chocolate Muffin")
                .price(new BigDecimal("4.99"))
                .menu(secondBreakfastMenu)
                .build();
        Dish vanillaMuffin = Dish.builder()
                .id(UUID.fromString("5b77a0a6-91ff-11ee-b9d1-0242ac120002"))
                .name("Vanilla Muffin")
                .price(new BigDecimal("3.99"))
                .menu(secondBreakfastMenu)
                .build();
        Dish pumpkinSpiceMuffin = Dish.builder()
                .id(UUID.fromString("667464da-91ff-11ee-b9d1-0242ac120002"))
                .name("Pumpkin Spice Muffin")
                .price(new BigDecimal("7.99"))
                .menu(secondBreakfastMenu)
                .build();
        Dish fruitSalad = Dish.builder()
                .id(UUID.fromString("7403d996-91ff-11ee-b9d1-0242ac120002"))
                .name("Fruit Salad")
                .price(new BigDecimal("7.99"))
                .menu(secondBreakfastMenu)
                .build();

        dishService.create(chocolateMuffin);
        dishService.create(pumpkinSpiceMuffin);
        dishService.create(fruitSalad);
        dishService.create(vanillaMuffin);

        Menu dinnerMenu = Menu.builder()
                .id(UUID.fromString("e0e85cb8-9204-11ee-b9d1-0242ac120002"))
                .name("Dinner")
                .startDate(LocalDate.of(2023, 2, 1))
                .endDate(LocalDate.of(2023, 12, 7))
                .build();

        Dish steak = Dish.builder()
                .id(UUID.fromString("fbf90e60-9203-11ee-b9d1-0242ac120002"))
                .name("Steak")
                .price(new BigDecimal("15.99"))
                .menu(dinnerMenu)
                .build();

        Dish pasta = Dish.builder()
                .id(UUID.fromString("0a7d0e34-9204-11ee-b9d1-0242ac120002"))
                .name("Pasta")
                .price(new BigDecimal("12.99"))
                .menu(dinnerMenu)
                .build();

        menuService.create(dinnerMenu);
        dishService.create(steak);
        dishService.create(pasta);
        Menu supperMenu = Menu.builder()
                .id(UUID.fromString("1f3c08fe-9204-11ee-b9d1-0242ac120002"))
                .name("Supper")
                .startDate(LocalDate.of(2023, 10, 1))
                .endDate(LocalDate.of(2023, 11, 7))
                .build();

        Dish soup = Dish.builder()
                .id(UUID.fromString("2b63e9c0-9204-11ee-b9d1-0242ac120002"))
                .name("Soup")
                .price(new BigDecimal("6.99"))
                .menu(supperMenu)
                .build();

        Dish chicken = Dish.builder()
                .id(UUID.fromString("367b7c4a-9204-11ee-b9d1-0242ac120002"))
                .name("Chicken")
                .price(new BigDecimal("11.99"))
                .menu(supperMenu)
                .build();
        menuService.create(supperMenu);
        dishService.create(soup);
        dishService.create(chicken);


}
    @SneakyThrows
    private byte[] getResourceAsByteArray(String name) {
        try (InputStream is = this.getClass().getResourceAsStream(name)) {
            return is.readAllBytes();
        }
    }
}

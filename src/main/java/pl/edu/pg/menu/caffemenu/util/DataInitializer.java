//package pl.edu.pg.menu.caffemenu.util;
//
//import jakarta.annotation.PostConstruct;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import pl.edu.pg.menu.caffemenu.entity.Dish;
//import pl.edu.pg.menu.caffemenu.entity.Menu;
//import pl.edu.pg.menu.caffemenu.service.DishService;
//import pl.edu.pg.menu.caffemenu.service.MenuService;
//
//import java.io.InputStream;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.UUID;
//
//@Component
//public class DataInitializer implements InitializingBean {
//    private final DishService dishService;
//    private final MenuService menuService;
//    @Autowired
//    public DataInitializer(DishService dishService, MenuService menuService) {
//        this.dishService = dishService;
//        this.menuService = menuService;
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        Menu secondBreakfastMenu = Menu.builder()
//                .id(UUID.randomUUID())
//                .name("Second Breakfast")
//                .startDate(LocalDate.of(2023, 5, 1))
//                .endDate(LocalDate.of(2023, 6, 7))
//                .dishes(List.of(
//                        Dish.builder()
//                                .id(UUID.fromString("364f31e0-91ff-11ee-b9d1-0242ac120002"))
//                                .name("Chocolate Muffin")
//                                .price(new BigDecimal("4.99"))
//                                .build(),
//                        Dish.builder()
//                                .id(UUID.fromString("5b77a0a6-91ff-11ee-b9d1-0242ac120002"))
//                                .name("Vanilla Muffin")
//                                .price(new BigDecimal("3.99"))
//                                .build(),
//                        Dish.builder()
//                                .id(UUID.fromString("667464da-91ff-11ee-b9d1-0242ac120002"))
//                                .name("Pumpkin Spice Muffin")
//                                .price(new BigDecimal("7.99"))
//                                .build(),
//
//                        Dish.builder()
//                                .id(UUID.fromString("7403d996-91ff-11ee-b9d1-0242ac120002"))
//                                .name("Fruit Salad")
//                                .price(new BigDecimal("7.99"))
//                                .build()
//                ))
//                .build();
//        secondBreakfastMenu.getDishes().forEach(dish -> {dish.setMenu(secondBreakfastMenu);});
//        menuService.create(secondBreakfastMenu);
//        secondBreakfastMenu.getDishes().forEach(dishService::create);
//
////        Menu dinnerMenu = Menu.builder()
////            .id(UUID.randomUUID())
////            .name("Dinner")
////            .startDate(LocalDate.of(2023, 2, 1))
////            .endDate(LocalDate.of(2023, 12, 7))
////            .dishes(List.of(
////                    Dish.builder()
////                            .id(UUID.randomUUID())
////                            .name("Steak")
////                            .price(new BigDecimal("15.99"))
////                            .build(),
////                    Dish.builder()
////                            .id(UUID.randomUUID())
////                            .name("Pasta")
////                            .price(new BigDecimal("12.99"))
////                            .build()
////            ))
////            .build();
////        dinnerMenu.getDishes().forEach(dish -> {dish.setMenu(dinnerMenu);});
////        menuService.create(dinnerMenu);
////        secondBreakfastMenu.getDishes().forEach(dishService::create);
////
////    Menu supperMenu = Menu.builder()
////            .id(UUID.randomUUID())
////            .name("Supper")
////            .startDate(LocalDate.of(2023, 10, 1))
////            .endDate(LocalDate.of(2023, 11, 7))
////            .dishes(List.of(
////                    Dish.builder()
////                            .id(UUID.randomUUID())
////                            .name("Soup")
////                            .price(new BigDecimal("6.99"))
////                            .build(),
////                    Dish.builder()
////                            .id(UUID.randomUUID())
////                            .name("Chicken")
////                            .price(new BigDecimal("11.99"))
////                            .build()
////            ))
////            .build();
////        supperMenu.getDishes().forEach(dish -> {dish.setMenu(supperMenu);});
////        menuService.create(supperMenu);
////        supperMenu.getDishes().forEach(dishService::create);
//
//}
//    @SneakyThrows
//    private byte[] getResourceAsByteArray(String name) {
//        try (InputStream is = this.getClass().getResourceAsStream(name)) {
//            return is.readAllBytes();
//        }
//    }
//}

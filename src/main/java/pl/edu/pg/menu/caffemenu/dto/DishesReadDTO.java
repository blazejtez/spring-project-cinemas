package pl.edu.pg.menu.caffemenu.dto;

import lombok.*;
import pl.edu.pg.menu.caffemenu.entity.Dish;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class DishesReadDTO {
    @Getter
    @Setter
    @Builder(access = AccessLevel.PUBLIC)
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Dish {
        private UUID id;
        private String name;

    }
    @Singular("dish")
    private List<Dish> dishes;
}

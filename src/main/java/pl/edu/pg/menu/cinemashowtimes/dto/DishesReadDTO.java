package pl.edu.pg.menu.cinemashowtimes.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

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

package pl.edu.pg.menu.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.cinemashowtimes.dto.DishesReadDTO;
import pl.edu.pg.menu.cinemashowtimes.entity.Showtime;

import java.util.List;
import java.util.function.Function;

@Component
public class DishesToDishesReadDTO implements Function<List<Showtime>, DishesReadDTO> {

    @Override
    public DishesReadDTO apply(List<Showtime> entities) {
        return DishesReadDTO.builder()
                .dishes(entities.stream()
                        .map(dish -> DishesReadDTO.Dish.builder()
                                .id(dish.getId())
                                .name(dish.getName())
                                .build())
                        .toList())
                .build();
    }
}

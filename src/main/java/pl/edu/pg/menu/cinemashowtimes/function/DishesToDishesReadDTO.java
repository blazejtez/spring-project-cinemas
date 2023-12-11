package pl.edu.pg.menu.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.cinemashowtimes.dto.ShowtimesReadDTO;
import pl.edu.pg.menu.cinemashowtimes.entity.Showtime;

import java.util.List;
import java.util.function.Function;

@Component
public class DishesToDishesReadDTO implements Function<List<Showtime>, ShowtimesReadDTO> {

    @Override
    public ShowtimesReadDTO apply(List<Showtime> entities) {
        return ShowtimesReadDTO.builder()
                .showtimes(entities.stream()
                        .map(dish -> ShowtimesReadDTO.Showtime.builder()
                                .id(dish.getId())
                                .description(dish.getName())
                                .build())
                        .toList())
                .build();
    }
}

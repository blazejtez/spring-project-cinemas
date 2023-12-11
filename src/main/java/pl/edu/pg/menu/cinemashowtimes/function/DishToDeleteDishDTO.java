package pl.edu.pg.menu.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.cinemashowtimes.entity.Showtime;

import java.util.function.Function;
@Component
public class DishToDeleteDishDTO  implements Function<Showtime, DeleteDishDTO> {
    @Override
    public DeleteDishDTO apply(Showtime entity) {
        return DeleteDishDTO.builder().build();
    }
}

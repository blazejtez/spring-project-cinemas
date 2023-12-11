package pl.edu.pg.menu.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.cinemashowtimes.dto.ShowtimeReadDTO;
import pl.edu.pg.menu.cinemashowtimes.entity.Showtime;

import java.util.function.Function;

@Component
public class DishToDishReadDTO implements Function<Showtime, ShowtimeReadDTO> {

    @Override
    public ShowtimeReadDTO apply(Showtime entity) {
        return ShowtimeReadDTO.builder().price(entity.getPrice()).name(entity.getName()).build();
    }
}
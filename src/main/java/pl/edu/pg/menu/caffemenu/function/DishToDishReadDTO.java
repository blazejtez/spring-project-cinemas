package pl.edu.pg.menu.caffemenu.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.caffemenu.dto.DishReadDTO;
import pl.edu.pg.menu.caffemenu.entity.Showtime;

import java.util.function.Function;

@Component
public class DishToDishReadDTO implements Function<Showtime, DishReadDTO> {

    @Override
    public DishReadDTO apply(Showtime entity) {
        return DishReadDTO.builder().price(entity.getPrice()).name(entity.getName()).build();
    }
}
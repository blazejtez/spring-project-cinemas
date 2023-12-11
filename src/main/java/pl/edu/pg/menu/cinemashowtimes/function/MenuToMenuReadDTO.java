package pl.edu.pg.menu.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.cinemashowtimes.dto.MenuReadDTO;
import pl.edu.pg.menu.cinemashowtimes.entity.Cinema;

import java.util.function.Function;
@Component
public class MenuToMenuReadDTO implements Function<Cinema, MenuReadDTO> {

    @Override
    public MenuReadDTO apply(Cinema entity) {
        return MenuReadDTO.builder()
                .name(entity.getName())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .build();
    }
}

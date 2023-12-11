package pl.edu.pg.menu.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.cinemashowtimes.dto.CinemaReadDTO;
import pl.edu.pg.menu.cinemashowtimes.entity.Cinema;

import java.util.function.Function;
@Component
public class MenuToMenuReadDTO implements Function<Cinema, CinemaReadDTO> {

    @Override
    public CinemaReadDTO apply(Cinema entity) {
        return CinemaReadDTO.builder()
                .name(entity.getName())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .build();
    }
}

package pl.edu.pg.menu.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.cinemashowtimes.dto.CinemasReadDTO;
import pl.edu.pg.menu.cinemashowtimes.entity.Cinema;

import java.util.List;
import java.util.function.Function;
@Component
public class MenuToMenusReadDTO implements Function<List<Cinema>, CinemasReadDTO> {
    @Override
    public CinemasReadDTO apply(List<Cinema> entities) {
        return CinemasReadDTO.builder()
                .cinemas(entities.stream()
                        .map( menu -> CinemasReadDTO.Cinema.builder()
                                .id(menu.getId())
                                .name(menu.getName())
                                .build())
                        .toList())
                .build();
    }
}

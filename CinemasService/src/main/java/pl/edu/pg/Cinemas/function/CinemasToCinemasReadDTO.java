package pl.edu.pg.Cinemas.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.Cinemas.dto.CinemasReadDTO;
import pl.edu.pg.Cinemas.entity.Cinema;

import java.util.List;
import java.util.function.Function;

@Component
public class CinemasToCinemasReadDTO implements Function<List<Cinema>, CinemasReadDTO> {
    @Override
    public CinemasReadDTO apply(List<Cinema> entities) {
        return CinemasReadDTO.builder()
                .cinemas(entities.stream()
                        .map( cinema -> CinemasReadDTO.Cinema.builder()
                                .id(cinema.getId())
                                .description("Famous " + cinema.getName() + " in " + cinema.getCity() + " at " + cinema.getStreet())
                                .build())
                        .toList())
                .build();
    }
}

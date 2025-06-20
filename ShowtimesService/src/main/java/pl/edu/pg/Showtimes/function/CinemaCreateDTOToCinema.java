package pl.edu.pg.Showtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.Showtimes.entity.Cinema;

import java.util.UUID;
import java.util.function.Function;

@Component
public class CinemaCreateDTOToCinema implements Function<UUID, Cinema> {
    @Override
    public Cinema apply(UUID uuid) {
        return Cinema.builder()
                .id(uuid)
                .build();
    }
}

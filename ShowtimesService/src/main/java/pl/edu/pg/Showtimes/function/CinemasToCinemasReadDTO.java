package pl.edu.pg.Showtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.Showtimes.dto.CinemasReadDTO;
import pl.edu.pg.Showtimes.entity.Cinema;

import java.util.List;
import java.util.function.Function;

@Component
public class CinemasToCinemasReadDTO implements Function<List<Cinema>, CinemasReadDTO> {
	@Override
	public CinemasReadDTO apply(List<Cinema> entities) {
		return CinemasReadDTO.builder().cinemas(entities.stream().map(cinema -> CinemasReadDTO.Cinema.builder().id(cinema.getId())
				.description("Cinema id:" + cinema.getId()).build()).toList()).build();
	}
}

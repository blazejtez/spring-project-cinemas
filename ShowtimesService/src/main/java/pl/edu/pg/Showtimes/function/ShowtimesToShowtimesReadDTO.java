package pl.edu.pg.Showtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.Showtimes.dto.ShowtimesReadDTO;
import pl.edu.pg.Showtimes.entity.Showtime;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

@Component
public class ShowtimesToShowtimesReadDTO implements Function<List<Showtime>, ShowtimesReadDTO> {

	@Override
	public ShowtimesReadDTO apply(List<Showtime> entities) {
		return ShowtimesReadDTO.builder().showtimes(entities.stream().map(showtime -> ShowtimesReadDTO.Showtime.builder().id(showtime.getId()).description(
				"A movie titled \"" + showtime.getMovieTitle() + "\" screened in cinema " + showtime.getCinema().getId() + " at " + showtime.getScreeningTime()
						.format(DateTimeFormatter.ofPattern("HH:mm")) + '.').build()).toList()).build();
	}
}

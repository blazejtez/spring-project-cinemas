package pl.edu.pg.Showtimes.function;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.Showtimes.dto.ShowtimeCreateDTO;
import pl.edu.pg.Showtimes.entity.Cinema;
import pl.edu.pg.Showtimes.entity.Showtime;
import pl.edu.pg.Showtimes.service.CinemaService;

import java.util.UUID;
@Component
public class ShowtimeCreateDTOToShowtime {
    @Autowired
    private final CinemaService cinemaService;

    public ShowtimeCreateDTOToShowtime(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    public Showtime apply(UUID cinemaUuid, UUID showtimeUuid, ShowtimeCreateDTO showtimeCreateDTO) {
        try {
            Cinema cinema = this.cinemaService.findById(cinemaUuid);
            return Showtime.builder()
                    .id(showtimeUuid)
                    .movieTitle(showtimeCreateDTO.getMovieTitle())
                    .showRoomName(showtimeCreateDTO.getShowRoomName())
                    .ticketPrice(showtimeCreateDTO.getTicketPrice())
                    .numberOfTickets(showtimeCreateDTO.getNumberOfTickets())
                    .screeningTime(showtimeCreateDTO.getScreeningTime())
                    .cinema(cinema)
                    .build();
        }
        //TODO SPRAWDŹ TO
        catch (EntityNotFoundException e) {
            e.printStackTrace();
            throw new EntityNotFoundException("Cinema not found.");
        }
    }
}

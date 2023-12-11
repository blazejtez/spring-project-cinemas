package pl.edu.pg.cinema.cinemashowtimes.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.pg.cinema.cinemashowtimes.dto.ShowtimeCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.repository.ShowtimeRepository;
import pl.edu.pg.cinema.cinemashowtimes.entity.Showtime;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShowtimeService {
    private ShowtimeRepository showtimeRepository;
    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }



    public void create(ShowtimeCreateDTO showtime) {
        Showtime showtimeEntity = Showtime
                .builder()
                .id(UUID.randomUUID())
                .movieTitle(showtime.getMovieTitle())
                .numberOfTickets(showtime.getNumberOfTickets())
                .screeningTime(showtime.getScreeningTime())
                .showRoomName(showtime.getShowRoomName())
                .ticketPrice(showtime.getTicketPrice())
                .description("Thrilling movie titled: "
                        +showtime.getMovieTitle()
                        +" with "
                        +showtime.getNumberOfTickets()
                        +" still available, soon, on"
                        +showtime.getScreeningTime())
                //TODO what to do about the cinema...?
                .build();
        showtimeRepository.save(showtimeEntity);
    }

    public List<Showtime> findAll() {
        return this.showtimeRepository.findAll();
    }
    public void delete(UUID uuid) {
        Optional<Showtime> optionalDish = this.showtimeRepository.findById(uuid);
        optionalDish.ifPresent(dish -> this.showtimeRepository.delete(dish));
    }

    public Showtime findById(UUID uuid) {
        Showtime showtime = this.showtimeRepository
                .findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Dish not found with id: " + uuid));
        return showtime;
    }

    public void deleteById(UUID uuid) {
    }
}

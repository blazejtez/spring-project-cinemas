package pl.edu.pg.cinema.cinemashowtimes.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.cinema.cinemashowtimes.dto.ShowtimeCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.dto.ShowtimesReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.entity.Showtime;
import pl.edu.pg.cinema.cinemashowtimes.function.ShowtimeCreateDTOToShowtime;
import pl.edu.pg.cinema.cinemashowtimes.function.ShowtimeToShowtimeReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.function.ShowtimesToShowtimesReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.service.CinemaService;
import pl.edu.pg.cinema.cinemashowtimes.service.ShowtimeService;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("api/cinemas/{cinemaUuid}/showtimes")
public class CinemaShowtimeController {
    private final ShowtimeService showtimeService;
    private final ShowtimesToShowtimesReadDTO showtimesToShowtimesReadDTO;
    private final ShowtimeToShowtimeReadDTO showtimeToShowtimeReadDTO;
    private final ShowtimeCreateDTOToShowtime showtimeCreateDTOToShowtime;
    private final CinemaService cinemaService;

    public CinemaShowtimeController(ShowtimeService showtimeService,
                                    ShowtimesToShowtimesReadDTO showtimesToShowtimesReadDTO,
                                    ShowtimeToShowtimeReadDTO showtimeToShowtimeReadDTO,
                                    ShowtimeCreateDTOToShowtime showtimeCreateDTOToShowtime,
                                    CinemaService cinemaService) {
        this.showtimeService = showtimeService;
        this.showtimesToShowtimesReadDTO = showtimesToShowtimesReadDTO;
        this.showtimeToShowtimeReadDTO = showtimeToShowtimeReadDTO;
        this.showtimeCreateDTOToShowtime = showtimeCreateDTOToShowtime;
        this.cinemaService = cinemaService;
    }

    @GetMapping
    ResponseEntity<ShowtimesReadDTO> getCinemaShowtimes(@PathVariable UUID cinemaUuid)
    {
        try {
            this.cinemaService.findById(cinemaUuid);
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }
        List<Showtime> showtimes = this.showtimeService.findFromCinema(cinemaUuid);
        ShowtimesReadDTO showtimesReadDTO = this.showtimesToShowtimesReadDTO.apply(showtimes);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CinemaShowtimeController");
        return ResponseEntity.accepted().headers(headers).body(showtimesReadDTO);
    }


    @PutMapping("{showtimeUuid}")
    ResponseEntity<String> postShowtime(@RequestBody ShowtimeCreateDTO showtimeCreateDTO, @RequestParam UUID cinemaUuid,
                                        @RequestParam UUID showtimeUuid)
    {
        try
        {
            Showtime showtime = showtimeCreateDTOToShowtime.apply(cinemaUuid, showtimeUuid, showtimeCreateDTO);
            this.showtimeService.create(showtime);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body("Successfully created");
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("Cinema not found");
        }

    }
    @DeleteMapping("{showtimeUuid}")
    ResponseEntity<String> deleteShowtime(@PathVariable UUID showtimeUuid, @PathVariable UUID cinemaUuid)
    {
        try {
            this.cinemaService.findById(cinemaUuid);
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("Cinema Not Found");
        }
        try
        {
            Showtime showtime = this.showtimeService.findById(showtimeUuid);
            this.showtimeService.deleteById(showtimeUuid);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body("Succesfully deleted " + showtimeUuid.toString());
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("Showtime with UUID " + showtimeUuid.toString() + " not found.");
        }
    }
}
